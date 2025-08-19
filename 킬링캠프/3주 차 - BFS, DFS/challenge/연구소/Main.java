import java.util.*;

public class Main {

    private static final int[][] MOVE = new int[][]{{-1, 0}, {0, 1}, {0, -1}, {1, 0}};  // 북, 동, 서, 남

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M;
        N = sc.nextInt();
        M = sc.nextInt();

        int[][] board = new int[N][M];
        List<Point> empty = new ArrayList<>();
        List<Point> wall = new ArrayList<>();
        List<Point> virus = new ArrayList<>();
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                int input = sc.nextInt();
                board[row][col] = input;
                if (input == 0) {
                    empty.add(new Point(row, col));
                } else if (input == 1) {
                    wall.add(new Point(row, col));
                } else {
                    virus.add(new Point(row, col));
                }
            }
        }

        List<List<Point>> wallCandidates = new ArrayList<>();
        getCombi(empty, wallCandidates, new ArrayList<>(), 0);

        int result = 0;
        for (List<Point> candidate : wallCandidates) {
            int[][] copyBoard = new int[N][M];
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < M; col++) {
                    copyBoard[row][col] = board[row][col];
                }
            }

            for (Point p : candidate) {
                copyBoard[p.row][p.col] = 1;
            }

            int newVirusCount = bfs(copyBoard, virus);
            int safeArea = empty.size() - 3 - newVirusCount;
            result = Math.max(result, safeArea);
        }

        System.out.println(result);
    }

    private static void getCombi(List<Point> empty, List<List<Point>> combi, List<Point> temp, int start) {
        if (temp.size() == 3) {
            combi.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < empty.size(); i++) {
            temp.add(empty.get(i));
            getCombi(empty, combi, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    private static int bfs(int[][] board, List<Point> virus) {
        int virusCount = 0;
        Deque<Point> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (Point p : virus) {
            dq.offer(p);
            visited[p.row][p.col] = true;
        }

        while (!dq.isEmpty()) {
            Point cur = dq.poll();
            for (int d = 0; d < 4; d++) {
                Point next = new Point(cur.row + MOVE[d][0], cur.col + MOVE[d][1]);
                if (!isSafe(board, next) || visited[next.row][next.col]) {
                    continue;
                }

                board[next.row][next.col] = 2;
                virusCount++;
                dq.offer(new Point(next.row, next.col));
                visited[next.row][next.col] = true;
            }
        }

        return virusCount;
    }

    private static boolean isSafe(int[][] board, Point p) {
        return p.row >= 0 && p.row < board.length && p.col >= 0 && p.col < board[p.row].length && board[p.row][p.col] == 0;
    }
}

class Point {
    int row;
    int col;

    Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

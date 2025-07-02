import java.util.*;

class Solution {
    public int solution(int[][] board) {
        return bfs(board);
    }

    private int bfs(int[][] board) {
        Deque<Robot> dq = new ArrayDeque<>();
        Set<Robot> visited = new HashSet<>();
        dq.offer(new Robot(0, 0, 0, 0));
        visited.add(dq.peek());

        while (!dq.isEmpty()) {
            Robot cur = dq.poll();

            for (int d = 0; d < 4; d++) {
                Robot next = cur.move(d);
                if (!next.isSafe(board) || isVisited(visited, next)) {
                    continue;
                }

                if (next.isArrived(board)) {
                    return next.step;
                }

                dq.offer(next);
                visited.add(next);
            }

            for (int d = 0; d < 4; d++) {
                Robot next = cur.rotation(d);
                if (!next.isSafe(board) || !cur.rotationSafe(board, d) || isVisited(visited, next)) {
                    continue;
                }

                if (next.isArrived(board)) {
                    return next.step;
                }

                dq.offer(next);
                visited.add(next);
            }
        }

        return -1;
    }

    private boolean isVisited(Set<Robot> visited, Robot target) {
        for (Robot r : visited) {
            if (r.row == target.row && r.col == target.col && r.rot == target.rot) {
                return true;
            }
        }

        return false;
    }
}

class Robot {

    private static final int WALL = 1;
    private static final int[][] MOVE = new int[][]{{-1, 0}, {0, 1}, {0, -1}, {1, 0}};  // 북, 동, 서, 남
    private static final int[][] ROT_R = new int[][]{{-1, 0, -1, 0}, {0, 0, 1, 1}};
    private static final int[][] ROT_C = new int[][]{{0, 0, 1, 1}, {0, -1, 0, -1}};
    private static final int[][] ROT_CHECK_R = new int[][]{{-1, 1, -1, 1}, {1, 1, 0, 0}};
    private static final int[][] ROT_CHECK_C = new int[][]{{1, 1, 0, 0}, {1, -1, 1, -1}};
    private static final int[][] OTHER_PART_OFFSET = new int[][] {{0, 1}, {1, 0}};

    int row;
    int col;
    int rot;
    int step;

    Robot(int row, int col, int rot, int step) {
        this.row = row;
        this.col = col;
        this.rot = rot;
        this.step = step;
    }

    public Robot move(int d) {
        return new Robot(row + MOVE[d][0], col + MOVE[d][1], rot, step + 1);
    }

    public Robot rotation(int d) {
        return new Robot(row + ROT_R[rot][d], col + ROT_C[rot][d], rotToggle(), step + 1);
    }

    private int rotToggle() {
        if (rot == 0) {
            return 1;
        }

        return 0;
    }

    public boolean isSafe(int[][] board) {
        int n = board.length;
        int otherPartRow = row + OTHER_PART_OFFSET[rot][0];
        int otherPartCol = col + OTHER_PART_OFFSET[rot][1];

        return row >= 0 && row < n && col >= 0 && col < n && board[row][col] != WALL
            && otherPartRow >= 0 && otherPartRow < n && otherPartCol >= 0 && otherPartCol < n && board[otherPartRow][otherPartCol] != WALL;
    }

    public boolean rotationSafe(int[][] board, int d) {
        int cornerRow = row + ROT_CHECK_R[rot][d];
        int cornerCol = col + ROT_CHECK_C[rot][d];

        return board[cornerRow][cornerCol] != WALL;
    }

    public boolean isArrived(int[][] board) {
        int n = board.length;
        int otherPartRow = row + OTHER_PART_OFFSET[rot][0];
        int otherPartCol = col + OTHER_PART_OFFSET[rot][1];

        return (row == n - 1 && col == n - 1) || (otherPartRow == n - 1 && otherPartCol == n - 1);
    }
}

import java.util.*;

class Solution {

    private static final int[][] DIR = new int[][]{{-1, 0}, {0, 1}, {0, -1}, {1, 0}};   // 북, 동, 서, 남

    public int[] solution(String[][] places) {
        int[] result = new int[places.length];
        outer: for (int i = 0; i < places.length; i++) {
            char[][] target = createTarget(places[i]);
            for (int row = 0; row < target.length; row++) {
                for (int col = 0; col < target[row].length; col++) {
                    if (target[row][col] != 'P') {
                        continue;
                    }

                    if (!bfs(target, row, col)) {
                        continue outer;
                    }
                }
            }

            result[i] = 1;
        }

        return result;
    }

    private char[][] createTarget(String[] place) {
        char[][] target = new char[5][5];
        for (int i = 0; i < 5; i++) {
            String s = place[i];
            for (int j = 0; j < 5; j++) {
                target[i][j] = s.charAt(j);
            }
        }

        return target;
    }

    private boolean bfs(char[][] places, int startRow, int startCol) {
        boolean[][] visited = new boolean[places.length][places[0].length];
        Deque<Node> dq = new ArrayDeque<>();
        dq.offer(new Node(startRow, startCol, 0));
        visited[startRow][startCol] = true;

        while (!dq.isEmpty()) {
            Node cur = dq.poll();
            for (int i = 0; i < DIR.length; i++) {
                Node next = new Node(cur.row + DIR[i][0], cur.col + DIR[i][1], cur.step + 1);
                if (!isSafe(places, next) || visited[next.row][next.col] || next.step > 2 || (next.step == 1 && places[next.row][next.col] == 'X')) {
                    continue;
                }

                if (places[next.row][next.col] == 'P') {
                    return false;
                }

                dq.offer(next);
                visited[next.row][next.col] = true;
            }
        }

        return true;
    }

    private boolean isSafe(char[][] places, Node node) {
        return node.row >= 0 && node.row < places.length && node.col >= 0 && node.col < places[node.row].length;
    }
}

class Node {
    int row;
    int col;
    int step;

    Node (int row, int col, int step) {
        this.row = row;
        this.col = col;
        this.step = step;
    }
}

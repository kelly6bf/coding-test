import java.util.*;

class Solution {

    private static final int[][] DIR = new int[][]{{-1, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 1}, {-1, -1}, {1, 1}, {1, -1}}; // 북, 동, 서, 남, 동북, 서북, 동남, 서남

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1;
        }

        return bfs(grid);
    }

    private int bfs(int[][] grid) {
        int gridWidth = grid.length;
        int gridHeight = grid[0].length;
        boolean[][] visited = new boolean[gridWidth][gridHeight];
        Deque<Node> dq = new ArrayDeque<>();
        dq.offer(new Node(0, 0, 1));
        visited[0][0] = true;

        while (!dq.isEmpty()) {
            Node cur = dq.poll();
            if (cur.row == (gridWidth - 1) && cur.col == (gridHeight - 1)) {
                return cur.seq;
            }

            for (int i = 0; i < 8; i++) {
                Node next = new Node(cur.row + DIR[i][0], cur.col + DIR[i][1], cur.seq + 1);
                if (!isSafe(grid, next) || visited[next.row][next.col]) {
                    continue;
                }

                dq.offer(next);
                visited[next.row][next.col] = true;
            }
        }

        return -1;
    }

    private boolean isSafe(int[][] grid, Node node) {
        int row = node.row;
        int col = node.col;

        return row >= 0 && row < grid.length && col >= 0 && col < grid[row].length && grid[row][col] == 0;
    }
}

class Node {
    int row;
    int col;
    int seq;

    Node(int row, int col, int seq) {
        this.row = row;
        this.col = col;
        this.seq = seq;
    }
}

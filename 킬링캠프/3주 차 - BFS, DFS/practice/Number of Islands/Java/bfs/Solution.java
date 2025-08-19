import java.util.*;

class Solution {

    private static final int[][] DIR = new int[][]{{-1, 0}, {0, 1}, {0, -1}, {1, 0}}; // 북, 동, 서, 남
    private static final char LAND = '1';
    private static final char WATER = '0';

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int result = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == WATER || visited[row][col]) {
                    continue;
                }

                bfs(grid, visited, new Node(row, col));
                result++;
            }
        }

        return result;
    }

    private void bfs(char[][] grid, boolean[][] visited, Node start) {
        Deque<Node> dq = new ArrayDeque<>();
        dq.offer(start);
        visited[start.row][start.col] = true;

        while (!dq.isEmpty()) {
            Node cur = dq.poll();
            for (int i = 0; i < 4; i++) {
                Node next = new Node(cur.row + DIR[i][0], cur.col + DIR[i][1]);
                if (!isSafe(grid, next) || visited[next.row][next.col]) {
                    continue;
                }

                dq.offer(next);
                visited[next.row][next.col] = true;
            }
        }
    }

    private boolean isSafe(char[][] grid, Node node) {
        int row = node.row;
        int col = node.col;

        return (row >= 0 && row < grid.length && col >= 0 && col < grid[row].length && grid[row][col] == LAND);
    }
}

class Node {
    int row;
    int col;

    Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

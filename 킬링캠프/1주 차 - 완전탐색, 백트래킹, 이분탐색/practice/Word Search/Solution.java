import java.util.*;

class Solution {

    // 북, 동, 서, 남
    private static final int[][] STEP = new int[][]{{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
    private static final char VISITED = '.';

    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] != word.charAt(0)) {
                    continue;
                }

                board[row][col] = VISITED;
                if (backTracking(board, word, row, col, 1)) {
                    return true;
                }

                board[row][col] = word.charAt(0);
            }
        }

        return false;
    }

    private boolean backTracking(char[][] board, String word, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            int nextRow = row + STEP[i][0];
            int nextCol = col + STEP[i][1];

            if (!isSafe(board, nextRow, nextCol) || board[nextRow][nextCol] != word.charAt(index)) {
                continue;
            }

            board[nextRow][nextCol] = VISITED;
            if (backTracking(board, word, nextRow, nextCol, index + 1)) {
                return true;
            }

            board[nextRow][nextCol] = word.charAt(index);
        }

        return false;
    }

    private boolean isSafe(char[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board[row].length && board[row][col] != VISITED) {
            return true;
        }

        return false;
    }
}

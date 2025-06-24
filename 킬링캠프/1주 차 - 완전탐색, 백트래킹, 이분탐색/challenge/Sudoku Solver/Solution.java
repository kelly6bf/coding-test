class Solution {

    private static final char EMPTY = '.';

    public void solveSudoku(char[][] board) {
        backTracking(board);
    }

    private boolean backTracking(char[][] board) {
        if (checkBoardFullFill(board)) {
            return true;
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] != EMPTY) {
                    continue;
                }

                for (int num = 1; num <= 9; num++) {
                    if (!isSafe(board, row, col, num)) {
                        continue;
                    }

                    board[row][col] = (char)(num + '0');
                    if (backTracking(board)) {
                        return true;
                    }

                    board[row][col] = EMPTY;
                }

                return false;
            }
        }

        return false;
    }

    private boolean checkBoardFullFill(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == EMPTY) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isSafe(char[][] board, int row, int col, int num) {
        for (int targetRow = 0; targetRow < board.length; targetRow++) {
            if (board[targetRow][col] == (char)(num + '0')) {
                return false;
            }
        }

        for (int targetCol = 0; targetCol < board.length; targetCol++) {
            if (board[row][targetCol] == (char)(num + '0')) {
                return false;
            }
        }

        int targetRow = getBaseIndex(row);
        int targetCol = getBaseIndex(col);
        for (int rowOffset = 0; rowOffset < 3; rowOffset++) {
            for (int colOffset = 0; colOffset < 3; colOffset++) {
                if (board[targetRow + rowOffset][targetCol + colOffset] == (char)(num + '0')) {
                    return false;
                }
            }
        }

        return true;
    }

    private int getBaseIndex(int target) {
        return switch(target % 3) {
            case 0 -> target;
            case 1 -> target - 1;
            case 2 -> target - 2;
            default -> -1;
        };
    } 
}

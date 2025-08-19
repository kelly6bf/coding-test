import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        backTracking(n, new boolean[n][n], result, new ArrayList<>(), 0);

        return result;
    }

    private void backTracking(int n, boolean[][] queens, List<List<String>> result, List<String> temp, int rowStart) {
        if (temp.size() == n) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int row = rowStart; row < queens.length; row++) {
            for (int col = 0; col < queens[row].length; col++) {
                if (!checkOtherQueens(queens, row, col)) {
                    continue;
                }

                queens[row][col] = true;
                String location = createLocation(n, col);
                temp.add(location);
                backTracking(n, queens, result, temp, row + 1);
                queens[row][col] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean checkOtherQueens(boolean[][] queens, int targetRow, int targetCol) {
        for (int row = 0; row < queens.length; row++) {
            if (queens[row][targetCol]) {
                return false;
            }
        }

        int currentRow = targetRow;
        int currentCol = targetCol;
        while (true) {
            currentRow -= 1;
            currentCol -= 1;

            if (!isSafe(queens.length, currentRow, currentCol)) {
                break;
            }

            if (queens[currentRow][currentCol]) {
                return false;
            }
        }

        currentRow = targetRow;
        currentCol = targetCol;
        while (true) {
            currentRow += 1;
            currentCol += 1;

            if (!isSafe(queens.length, currentRow, currentCol)) {
                break;
            }

            if (queens[currentRow][currentCol]) {
                return false;
            }
        }

        currentRow = targetRow;
        currentCol = targetCol;
        while (true) {
            currentRow -= 1;
            currentCol += 1;

            if (!isSafe(queens.length, currentRow, currentCol)) {
                break;
            }

            if (queens[currentRow][currentCol]) {
                return false;
            }
        }

        currentRow = targetRow;
        currentCol = targetCol;
        while (true) {
            currentRow += 1;
            currentCol -= 1;

            if (!isSafe(queens.length, currentRow, currentCol)) {
                break;
            }

            if (queens[currentRow][currentCol]) {
                return false;
            }
        }

        return true;
    }

    private boolean isSafe(int n, int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    private String createLocation(int n, int col) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == col) {
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }

        return sb.toString();
    }
}

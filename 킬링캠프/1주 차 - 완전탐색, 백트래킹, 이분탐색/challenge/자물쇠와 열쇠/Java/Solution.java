class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int N = lock.length;
        int M = key.length;
        for (int rowOffset = M; rowOffset > -N; rowOffset--) {
            for (int colOffset = M; colOffset > -N; colOffset--) {
                if (match(key, lock, rowOffset, colOffset)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean match(int[][] key, int[][] lock, int rowOffset, int colOffset) {
        int N = lock.length;
        int M = key.length;
        for (int rot = 0; rot < 4; rot++) {
            boolean matched = true;
            outer: for (int lockRow = 0; lockRow < N; lockRow++) {
                for (int lockCol = 0; lockCol < N; lockCol++) {
                    int keyPoint = 0;
                    int keyRow = lockRow + rowOffset;
                    int keyCol = lockCol + colOffset;

                    if (keyRow >= 0 && keyRow < M && keyCol >= 0 && keyCol < M) {
                        keyPoint = getKeyPoint(key, rot, keyRow, keyCol);
                    }

                    if ((lock[lockRow][lockCol] == 0 && keyPoint == 0) || (lock[lockRow][lockCol] == 1 && keyPoint == 1)) {
                        matched = false;
                        break outer;
                    }
                }
            }

            if (matched) {
                return true;
            }
        }

        return false;
    }

    private int getKeyPoint(int[][] key, int rot, int keyRow, int keyCol) {
        int M = key.length;
        return switch (rot) {
            case 0 -> key[keyRow][keyCol];
            case 1 -> key[M - keyCol - 1][keyRow];
            case 2 -> key[M - keyRow - 1][M - keyCol - 1];
            case 3 -> key[keyCol][M - keyRow - 1];
            default -> -1;
        };
    }
}

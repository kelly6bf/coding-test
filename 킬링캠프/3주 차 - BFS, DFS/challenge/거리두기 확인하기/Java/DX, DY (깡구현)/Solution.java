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

                    if (!check(target, row, col)) {
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

    private boolean check(char[][] places, int startRow, int startCol) {
        for (int i = 0; i < DIR.length; i++) {
            int oneStepRow = startRow + DIR[i][0];
            int oneStepCol = startCol + DIR[i][1];

            if (!isSafe(places, oneStepRow, oneStepCol)) {
                continue;
            }

            if (places[oneStepRow][oneStepCol] == 'P') {
                return false;
            }

            for (int j = 0; j < DIR.length; j++) {
                if (j == (DIR.length - i - 1)) {
                    continue;
                }

                int twoStepRow = oneStepRow + DIR[j][0];
                int twoStepCol = oneStepCol + DIR[j][1];

                if (!isSafe(places, twoStepRow, twoStepCol)) {
                    continue;
                }

                if (places[oneStepRow][oneStepCol] != 'X' && places[twoStepRow][twoStepCol] == 'P') {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isSafe(char[][] places, int row, int col) {
        return row >= 0 && row < places.length && col >= 0 && col < places[row].length;
    }
}

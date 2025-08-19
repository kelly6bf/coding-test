class Solution {

    static int maximum = 0;

    public int solution(int k, int[][] dungeons) {
        backTracking(k, dungeons, new boolean[dungeons.length], 0);
        return maximum;
    }

    private void backTracking(int k, int[][] dungeons, boolean[] visited, int count) {
        if (count > maximum) {
            maximum = count;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] || k < dungeons[i][0]) {
                continue;
            }

            visited[i] = true;
            backTracking(k - dungeons[i][1], dungeons, visited, count + 1);
            visited[i] = false;
        }
    }
}

import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        boolean[] visited = new boolean[graph.length];
        for (int start = 0; start < graph.length; start++) {
            if (visited[start]) {
                continue;
            }

            if (!dfs(graph, start, 1, colors, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int curV, int curColor, int[] colors, boolean[] visited) {
        visited[curV] = true;
        colors[curV] = curColor;
        for (int nextV : graph[curV]) {
            if (!visited[nextV]) {
                if (!dfs(graph, nextV, 3 - curColor, colors, visited)) {
                    return false;
                };
            }

            if (colors[nextV] == curColor) {
                return false;
            }
        }   

        return true;
    }
}

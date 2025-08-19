import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        boolean[] visited = new boolean[graph.length];
        for (int start = 0; start < graph.length; start++) {
            if (visited[start]) {
                continue;
            }

            if (!bfs(graph, start, colors, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean bfs(int[][] graph, int start, int[] colors, boolean[] visited) {
        Deque<Integer> dq = new ArrayDeque<>();
        visited[start] = true;
        dq.offer(start);
        colors[start] = 1;

        while (!dq.isEmpty()) {
            int v = dq.poll();
            int vColor = colors[v];
            for (int next : graph[v]) {
                if (!visited[next]) {
                    visited[next] = true;
                    dq.offer(next);
                    colors[next] = 3 - vColor;
                    continue;
                }

                if (colors[next] == vColor) {
                    return false;
                }
            }
        }

        return true;
    }
}

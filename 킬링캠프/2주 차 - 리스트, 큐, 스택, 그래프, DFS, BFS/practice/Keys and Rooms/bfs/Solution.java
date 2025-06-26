import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        bfs(rooms, visited, 0);
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;
    }

    private void bfs(List<List<Integer>> rooms, boolean[] visited, int start) {
        Deque<Integer> dq = new ArrayDeque<>();
        visited[start] = true;
        dq.offer(start);

        while (!dq.isEmpty()) {
            int current = dq.poll();
            for (int next : rooms.get(current)) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                dq.offer(next);
            }
        }
    }
}

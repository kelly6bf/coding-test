import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, visited, 0);
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;   
    }

    private void dfs(List<List<Integer>> rooms, boolean[] visited, int current) {
        visited[current] = true;
        for (int next : rooms.get(current)) {
            if (visited[next]) {
                continue;
            }
            dfs(rooms, visited, next);
        }
    }
}

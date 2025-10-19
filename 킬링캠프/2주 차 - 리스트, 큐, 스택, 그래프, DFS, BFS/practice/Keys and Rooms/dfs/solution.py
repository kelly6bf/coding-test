class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        visited = [False for _ in rooms]

        visited[0] = True
        self.dfs(rooms, visited, 0)

        return all(visited)

    def dfs(self, rooms, visited, current):
        for next in rooms[current]:
            if (visited[next]):
                continue
            
            visited[next] = True
            self.dfs(rooms, visited, next)

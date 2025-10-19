from collections import deque

class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        visited = [False for _ in rooms]
        dq = deque()

        dq.append(0)
        visited[0] = True

        while dq:
            current = dq.popleft()
            for next in rooms[current]:
                if visited[next]:
                    continue
                
                dq.append(next)
                visited[next] = True

        return all(visited)

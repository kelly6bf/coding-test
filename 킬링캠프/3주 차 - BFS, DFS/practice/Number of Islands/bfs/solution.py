from collections import deque

class Solution:

    DIR = [[-1, 0], [0, 1], [0, -1], [1, 0]]

    def numIslands(self, grid: List[List[str]]) -> int:
        answer = 0
        visited = [[False for _ in range(len(grid[0]))] for _ in range(len(grid))]

        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col] == "0" or visited[row][col]:
                    continue

                self.bfs(grid, visited, row, col)
                answer +=1
        
        return answer

    def bfs(self, grid, visited, start_row, start_col):
        dq = deque()
        dq.append([start_row, start_col])
        visited[start_row][start_col] = True

        while dq:
            current = dq.popleft()
            for dr, dc in self.DIR:
                next_row = current[0] + dr
                next_col = current[1] + dc

                if not self.is_safe(next_row, next_col, grid, visited):
                    continue

                visited[next_row][next_col] = True
                dq.append([next_row, next_col])
    
    def is_safe(self, row, col, grid, visited):
        return row >= 0 and row < len(grid) and col >= 0 and col < len(grid[row]) and grid[row][col] == "1" and not visited[row][col]

from collections import deque

class Solution:

    DIR = [[-1, 0], [0, 1], [0, -1], [1, 0], [-1, -1], [-1, 1], [1, -1], [1, 1]]

    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        if grid[0][0] == 1:
            return -1
        
        target_row = len(grid) - 1
        target_col = len(grid[0]) - 1
        visited = [[False for _ in range(len(grid[0]))] for _ in range(len(grid))]
        dq = deque()

        dq.append([0, 0, 1])
        visited[0][0] = True

        while dq:
            current_row, current_col, current_step = dq.popleft()
            if current_row == target_row and current_col == target_col:
                return current_step

            for dr, dc in self.DIR:
                next_row = current_row + dr
                next_col = current_col + dc

                if not self.is_safe(next_row, next_col, grid, visited):
                    continue

                dq.append([next_row, next_col, current_step + 1])
                visited[next_row][next_col] = True
        
        return -1
    
    def is_safe(self, row, col, grid, visited):
        return row >= 0 and row < len(grid) and col >= 0 and col < len(grid[row]) and grid[row][col] == 0 and not visited[row][col]

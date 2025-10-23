class Solution:
    DIR = [[-1, 0], [0, 1], [0, -1], [1, 0]]

    def numIslands(self, grid: List[List[str]]) -> int:
        answer = 0
        visited = [[False for _ in range(len(grid[0]))] for _ in range(len(grid))]

        for row in range(len(grid)):
            for col in range(len(grid[row])):
                if grid[row][col] == "0" or visited[row][col]:
                    continue

                self.dfs(grid, visited, row, col)
                answer += 1
        
        return answer

    def dfs(self, grid, visited, current_row, current_col):
        for dr, dc in self.DIR:
            next_row = current_row + dr
            next_col = current_col + dc

            if not self.is_safe(next_row, next_col, grid, visited):
                continue

            visited[next_row][next_col] = True
            self.dfs(grid, visited, next_row, next_col)
    
    def is_safe(self, row, col, grid, visited):
        return row >= 0 and row < len(grid) and col >= 0 and col < len(grid[row]) and grid[row][col] == "1" and not visited[row][col]

class Solution:
    DIR = [[-1, 0], [0, 1], [0, -1], [1, 0], [-1, 1], [-1, -1], [1, 1], [1, -1]]  # 북, 동, 서, 남, 북동, 북서, 남동, 남서

    def solveNQueens(self, n: int) -> List[List[str]]:
        result = []
        visited = [[False for _ in range(n)] for _ in range(n)]
        self.back_tracking(n, 0, 0, result, visited, 1)

        return result
    
    def back_tracking(self, n, start_row, start_col, result, visited, step):
        if (step > n):
            result.append(self.convert_visited_to_result(visited))
            return
        
        for row in range(start_row, n):
            start_col = start_col if row == start_row else 0
            for col in range(start_col, n):
                if (not self.is_safe(row, col, n, visited)):
                    continue
                
                visited[row][col] = True
                next_col = (col + 1) % n
                next_row = row + 1 if (next_col == 0) else row
                self.back_tracking(n, next_row, next_col, result, visited, step + 1)

                visited[row][col] = False
    
    def is_safe(self, row, col, n, visited):
        for d in self.DIR:
            next_row = row + d[0]
            next_col = col + d[1]

            while (next_row >= 0 and next_row < n and next_col >= 0 and next_col < n):
                if (visited[next_row][next_col]):
                    return False
                
                next_row += d[0]
                next_col += d[1]
        
        return True
    
    def convert_visited_to_result(self, visited):
        result = []
        for row in visited:
            row_str = ""
            for col in row:
                row_str += "Q" if (col) else "."
            result.append(row_str)
        
        return result

class Solution:
    DIR = [[-1, 0], [0, 1], [0, -1], [1, 0]] # 북, 동, 서, 남

    def exist(self, board: List[List[str]], word: str) -> bool:
        visited = [[False for _ in row] for row in board]

        for row in range(0, len(board)):
            for col in range(0, len(board[row])):
                if (board[row][col] != word[0]):
                    continue
                
                visited[row][col] = True
                if (self.backTracking(board, word, visited, row, col, 1)):
                    return True

                visited[row][col] = False
        
        return False

    
    def backTracking(self, board, word, visited, row, col, step):
        if (step == len(word)):
            return True

        for dr, dc in self.DIR:
            next_row = row + dr
            next_col = col + dc

            if (not self.is_safe(board, visited, next_row, next_col) or board[next_row][next_col] != word[step]):
                continue
            
            visited[next_row][next_col] = True
            if (self.backTracking(board, word, visited, next_row, next_col, step + 1)):
                return True

            visited[next_row][next_col] = False
        
        return False
    
    def is_safe(self, board, visited, row, col):
        return row >= 0 and row < len(board) and col >= 0 and col < len(board[row]) and not visited[row][col]

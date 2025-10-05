class Solution:
    EMPTY_STR = "."

    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        self.back_tracking(board)
    
    def back_tracking(self, board):
        if (self.is_full_fill(board)):
            return True
        
        for row in range(len(board)):
            for col in range(len(board[row])):
                if (board[row][col] != self.EMPTY_STR):
                    continue
                
                for candi in range(1, 10):
                    if (not self.is_safe(row, col, candi, board)):
                        continue
                    
                    board[row][col] = str(candi)
                    if (self.back_tracking(board)):
                        return True

                    board[row][col] = self.EMPTY_STR

                return False

        return False
    
    def is_full_fill(self, board):
        for row in board:
            for col in row:
                if (col == self.EMPTY_STR):
                    return False
        
        return True

    def is_safe(self, target_row, target_col, target, board):
        for col in range(len(board)):
            if (col == target_col):
                continue
            
            if (board[target_row][col] == str(target)):
                return False
        
        for row in range(len(board)):
            if (row == target_row):
                continue
            
            if (board[row][target_col] == str(target)):
                return False
        
        start_row = target_row - (target_row % 3)
        start_col = target_col - (target_col % 3)
        for row in range(start_row, start_row + 3):
            for col in range(start_col, start_col + 3):
                if (row == target_row and col == target_col):
                    continue
                
                if (board[row][col] == str(target)):
                    return False
        
        return True

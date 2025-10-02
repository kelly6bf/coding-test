def solution(key, lock):
    M = len(key)    # 키 크기
    N = len(lock)   # 자물쇠 크기

    for row_offset in range(M - 1, -N, -1):
        for col_offset in range(M - 1, -N, -1):
            for rot in range(4):
                if (match(key, lock, row_offset, col_offset, rot)):
                    return True
    
    return False

def match(key, lock, row_offset, col_offset, rot):
    N = len(lock)
    M = len(key)
    current_key = calculate_current_key(key, rot)

    for lock_row in range(N):
        key_row = lock_row + row_offset
        for lock_col in range(N):
            key_col = lock_col + col_offset

            if (key_row < 0 or key_row >= M or key_col < 0 or key_col >= M):
                if (lock[lock_row][lock_col] == 0):
                    return False
                else:
                    continue
            
            if ((lock[lock_row][lock_col] == 1 and current_key[key_row][key_col] == 1) or lock[lock_row][lock_col] == 0 and current_key[key_row][key_col] != 1):
                return False
    
    return True

def calculate_current_key(key, rot):
    if (rot == 0):
        return key

    M = len(key)
    current_key = [[0 for _ in range(M)] for _ in range(M)]
    for row in range(M):
        for col in range(M):
            if (key[row][col] != 1):
                continue
            if (rot == 1):
                current_key[col][M - row - 1] = 1
            elif (rot == 2):
                current_key[M - row - 1][M - col - 1] = 1
            else:
                current_key[M - col - 1][row] = 1
    
    return current_key

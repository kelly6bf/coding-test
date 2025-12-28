def solution(key, lock):
    # 전역 데이터
    M = len(key)
    N = len(lock)

    # 메서드
    def match(keyRowOffset, keyColOffset, rot):
        targetKey = calculateCurrentKey(rot)

        for lockRow in range(N):
            keyRow = lockRow + keyRowOffset
            
            for lockCol in range(N):
                keyCol = lockCol + keyColOffset

                if not isSafe(keyRow, keyCol):
                    if lock[lockRow][lockCol] == 0:
                        return False
                    else:
                        continue

                if (lock[lockRow][lockCol] == 1 and targetKey[keyRow][keyCol] == 1) or (lock[lockRow][lockCol] == 0 and targetKey[keyRow][keyCol] != 1):
                    return False
        
        return True

    def calculateCurrentKey(rot):
        if (rot == 0):
            return key

        curKey = [[0 for _ in range(M)] for _ in range(M)]
        for row in range(M):
            for col in range(M):
                if (key[row][col] == 0):
                    continue
                if (rot == 1):
                    curKey[col][M - row - 1] = 1
                elif (rot == 2):
                    curKey[M - row - 1][M - col - 1] = 1
                else:
                    curKey[M - col - 1][row] = 1
        
        return curKey
    
    def isSafe(keyRow, keyCol):
        return keyRow >= 0 and keyRow < M and keyCol >= 0 and keyCol < M

    # 메인 로직
    for keyRowOffset in range(M - 1, -N, -1):
        for keyColOffset in range(M - 1, -N, -1):
            for rot in range(4):
                if match(keyRowOffset, keyColOffset, rot):
                    return True
    
    return False

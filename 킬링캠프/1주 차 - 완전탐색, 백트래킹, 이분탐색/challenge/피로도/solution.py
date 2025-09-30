def solution(k, dungeons):
    visited = [False for _ in dungeons]
    return recursive(k, dungeons, 0, visited)

def recursive(k, dungeons, count, visited):
    max_count = count
    
    for i in range(0, len(dungeons)):
        minimumPoint, usePoint = dungeons[i]
        if (visited[i] or k < minimumPoint):
            continue
        
        visited[i] = True
        max_count = max(max_count, recursive(k - usePoint, dungeons, count + 1, visited))
        visited[i] = False
    
    return max_count

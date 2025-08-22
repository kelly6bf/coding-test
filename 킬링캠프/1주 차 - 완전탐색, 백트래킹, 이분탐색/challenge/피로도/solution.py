answer = 0

def solution(k, dungeons):
    global answer
    backTracking(k, dungeons, [False for _ in dungeons], 0)

    return answer

def backTracking(k, dungeons, visited, count):
    global answer

    answer = max(answer, count)

    for i in range(len(dungeons)):
        target = dungeons[i]
        if (visited[i] or k < target[0]):
            continue
        
        visited[i] = True
        backTracking(k - target[1], dungeons, visited, count + 1)
        visited[i] = False

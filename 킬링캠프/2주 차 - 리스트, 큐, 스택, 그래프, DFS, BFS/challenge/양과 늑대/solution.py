def solution(info, edges):
    answer = []
    visited = [False for _ in info]

    visited[0] = True
    dfs(1, 0, edges, info, visited, answer)

    return max(answer)

def dfs(sheep, wolf, edges, info, visited, answer):
    if sheep <= wolf:
        return
    
    answer.append(sheep)

    for p, c in edges:
        if visited[p] and not visited[c]:
            visited[c] = True
            if info[c] == 0:
                dfs(sheep + 1, wolf, edges, info, visited, answer)
            else:
                dfs(sheep, wolf + 1, edges, info, visited, answer)
            
            visited[c] = False

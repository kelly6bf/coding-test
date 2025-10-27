from itertools import combinations
from copy import deepcopy
from collections import deque

DIR = [(-1, 0), (0, 1), (0, -1), (1, 0)]

def gen_wall_combi(board, N, M):
    empty = []
    for row in range(N):
        for col in range(M):
            if board[row][col] == 0:
                empty.append((row, col))
    
    return list(combinations(empty, 3))

def bfs(board, N, M):
    dq = deque()

    for row in range(N):
        for col in range(M):
            if board[row][col] == 2:
                dq.append((row, col))
    
    while dq:
        row, col = dq.popleft()
        for dr, dc in DIR:
            next_row = row + dr
            next_col = col + dc

            if not is_safe(next_row, next_col, board, N, M) or board[next_row][next_col] != 0:
                continue

            board[next_row][next_col] = 2
            dq.append((next_row, next_col))

    safe_area = 0
    for row in board:
        for item in row:
            if item == 0:
                safe_area += 1

    return safe_area

def is_safe(row, col, board, N, M):
    return row >= 0 and row < N and col >= 0 and col < M

# 메인 로직
N, M = list(map(int, input().split()))
board = [list(map(int, input().split())) for _ in range(N)]

answer = 0
wall_combi = gen_wall_combi(board, N, M)
for candi in wall_combi:
    target = deepcopy(board)
    for c in candi:
        target[c[0]][c[1]] = 1
    
    answer = max(answer, bfs(target, N, M))

print(answer)

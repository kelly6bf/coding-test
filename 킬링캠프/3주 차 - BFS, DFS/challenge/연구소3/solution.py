from itertools import combinations
from collections import deque

WALL = "-"
EMPTY = "_"
INACTIVE = "*"
ACTIVE = 0
DIR = [[-1, 0], [0, 1], [0, -1], [1, 0]]

def bfs(board, N, combi):
    max_time = 0
    dq = deque()
    for row, col in combi:
        dq.append((row, col, 0))
    
    while dq:
        cur_r, cur_c, cur_time = dq.popleft()

        for dr, dc in DIR:
            next_r = cur_r + dr
            next_c = cur_c + dc
            next_time = cur_time + 1

            if not is_safe(next_r, next_c, N):
                continue

            if board[next_r][next_c] == EMPTY:
                board[next_r][next_c] = next_time
                dq.append((next_r, next_c, next_time))
                max_time = max(max_time, next_time)
            elif board[next_r][next_c] == INACTIVE:
                board[next_r][next_c] = next_time
                dq.append((next_r, next_c, next_time))
    
    for row in board:
        for col in row:
            if col == EMPTY:
                return 10000000
    
    return max_time

def is_safe(row, col, N):
    return row >= 0 and row < N and col >= 0 and col < N

# 메인 로직
N, M = list(map(int, input().split()))
board = [list(map(int, input().split())) for _ in range(N)]
virus_locations = []
for row in range(N):
    for col in range(N):
        if board[row][col] == 0:
            board[row][col] = EMPTY
        elif board[row][col] == 1:
            board[row][col] = WALL
        elif board[row][col] == 2:
            virus_locations.append((row, col))
            board[row][col] = INACTIVE

answer = 10000000
for combi in combinations(virus_locations, M):
    new_board = [row[:] for row in board]
    for row, col in combi:
        new_board[row][col] = ACTIVE
    
    answer = min(answer, bfs(new_board, N, combi))

print(answer if answer != 10000000 else -1)

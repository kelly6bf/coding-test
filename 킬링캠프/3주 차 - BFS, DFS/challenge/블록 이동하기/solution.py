from collections import deque

def solution(board):
    n = len(board)
    new_board = [[1 for _ in range(n + 2)] for _ in range(n + 2)]
    for row in range(n):
        for col in range(n):
            new_board[row + 1][col + 1] = board[row][col]

    visited = set()
    dq = deque()

    start_pos = ((1, 1), (1, 2))
    start_time = 0
    dq.append((start_pos, start_time))
    visited.add(start_pos)

    while dq:
        cur_pos, cur_time = dq.popleft()
        if (n, n) in cur_pos:
            return cur_time
        
        for next_pos in get_next_pos(cur_pos, new_board):
            if next_pos in visited:
                continue

            dq.append((next_pos, cur_time + 1))
            visited.add(next_pos)

def get_next_pos(cur_pos, board):
    next_pos_list = []
    r1, c1 = cur_pos[0]
    r2, c2 = cur_pos[1]

    dir = [[-1, 0], [0, 1], [0, -1], [1, 0]]
    for dr, dc in dir:
        next_r1 = r1 + dr
        next_c1 = c1 + dc
        next_r2 = r2 + dr
        next_c2 = c2 + dc

        if board[next_r1][next_c1] == 0 and board[next_r2][next_c2] == 0:
            next_pos_list.append(((next_r1, next_c1), (next_r2, next_c2)))
    
    # 현재 가로 상태
    if r1 == r2:
        if board[r1 - 1][c1] == 0 and board[r2 - 1][c2] == 0:
            next_pos_list.append(((r2 -1, c2), (r2, c2)))
            next_pos_list.append(((r1, c1), (r1 - 1, c1)))

        if board[r1 + 1][c1] == 0 and board[r2 + 1][c2] == 0:
            next_pos_list.append(((r2 + 1, c2), (r2, c2)))
            next_pos_list.append(((r1, c1), (r1 + 1, c1)))
    
    # 현재 새로 상태
    if c1 == c2:
        if board[r1][c1 + 1] == 0 and board[r2][c2 + 1] == 0:
            next_pos_list.append(((r2, c2 + 1), (r2, c2)))
            next_pos_list.append(((r1, c1), (r1, c1 + 1)))
        
        if board[r1][c1 - 1] == 0 and board[r2][c2 - 1] == 0:
            next_pos_list.append(((r2, c2 - 1), (r2, c2)))
            next_pos_list.append(((r1, c1), (r1, c1 - 1)))
    
    return next_pos_list

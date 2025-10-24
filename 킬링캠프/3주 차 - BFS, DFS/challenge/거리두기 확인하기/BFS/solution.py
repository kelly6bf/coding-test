from collections import deque

DIR = [[-1, 0], [0, 1], [0, -1], [1, 0]]

def solution(places):
    answer = [1 for _ in range(5)]
    for i in range(5):
        if not has_distance(places[i]):
            answer[i] = 0

    return answer

def has_distance(place):
    for row in range(5):
        for col in range(5):
            if place[row][col] != "P":
                continue

            if not check_distance(place, row, col):
                return False
    
    return True

def check_distance(place, start_row, start_col):
    visited = [[False for _ in range(5)] for _ in range(5)]
    dq = deque()
    dq.append([start_row, start_col, 0])
    visited[start_row][start_col] = True

    while dq:
        current_row, current_col, current_step = dq.popleft()

        for dr, dc in DIR:
            next_row = current_row + dr
            next_col = current_col + dc
            next_step = current_step + 1

            if not is_safe(next_row, next_col, visited) or next_step > 2:
                continue

            if place[next_row][next_col] == "P":
                return False
            elif next_step == 1 and place[next_row][next_col] == "O":
                dq.append([next_row, next_col, next_step])
                visited[next_row][next_col]
    
    return True

def is_safe(row, col, visited):
    return row >= 0 and row < 5 and col >= 0 and col < 5 and not visited[row][col]

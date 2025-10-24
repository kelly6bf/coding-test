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

def check_distance(place, row, col):
    for one_step_d in range(len(DIR)):
        one_step_row = row + DIR[one_step_d][0]
        one_step_col = col + DIR[one_step_d][1]

        if not is_safe(one_step_row, one_step_col):
            continue

        if place[one_step_row][one_step_col] == "P":
            return False
        elif place[one_step_row][one_step_col] == "X":
            continue
        
        for two_step_d in range(len(DIR)):
            if two_step_d == len(DIR) - one_step_d - 1:
                continue

            two_step_row = one_step_row + DIR[two_step_d][0]
            two_step_col = one_step_col + DIR[two_step_d][1]
            if not is_safe(two_step_row, two_step_col):
                continue

            if place[two_step_row][two_step_col] == "P":
                return False
    
    return True

def is_safe(row, col):
    return row >= 0 and row < 5 and col >= 0 and col < 5

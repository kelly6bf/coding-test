from collections import deque

def solution(queue1, queue2):
    dq_queue1 = deque(queue1)
    dq_queue2 = deque(queue2)

    queue_size = len(queue1)
    queue1_sum = sum(queue1)
    queue2_sum = sum(queue2)

    cnt = 0
    while cnt < queue_size * 4:
        if queue1_sum == queue2_sum:
            return cnt
        elif queue1_sum > queue2_sum:
            poped_item = dq_queue1.popleft()
            dq_queue2.append(poped_item)
            queue1_sum -= poped_item
            queue2_sum += poped_item
        else:
            poped_item = dq_queue2.popleft()
            dq_queue1.append(poped_item)
            queue1_sum += poped_item
            queue2_sum -= poped_item
        
        cnt += 1
    
    return -1

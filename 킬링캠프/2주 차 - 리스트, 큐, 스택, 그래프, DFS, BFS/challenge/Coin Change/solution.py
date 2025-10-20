from collections import deque

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dq = deque()
        dq.append((amount, 0))
        visited = {amount}
        
        while dq:
            current_amount, count = dq.popleft()

            if current_amount == 0:
                return count
                
            if current_amount < 0:
                continue
                
            for coin in coins:
                next_amout = current_amount - coin
                if next_amout in visited:
                    continue

                dq.append((next_amout, count + 1))
                visited.add(next_amout)

        return -1

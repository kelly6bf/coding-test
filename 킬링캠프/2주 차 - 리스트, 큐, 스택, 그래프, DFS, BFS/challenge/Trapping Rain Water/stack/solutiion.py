class Solution:
    def trap(self, height: List[int]) -> int:
        answer = 0
        trapped = height[::]
        stack = []

        for i, h in enumerate(height):
            if not stack:
                stack.append([i, h])
                continue
            
            last_poped_item = None
            for item in reversed(stack):
                if item[1] > h:
                    break

                last_poped_item = stack.pop()
            
            if last_poped_item is not None:
                start = stack[-1][0] + 1 if stack else last_poped_item[0] + 1
                trap_depth = h if stack else last_poped_item[1]
                for target_index in range(start, i):
                    trapped[target_index] = trap_depth
            
            stack.append([i, h])
        
        for i in range(len(trapped)):
            answer += trapped[i] - height[i]
        
        return answer

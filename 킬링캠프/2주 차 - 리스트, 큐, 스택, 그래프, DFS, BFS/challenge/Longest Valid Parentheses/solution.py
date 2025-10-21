class Solution:
    def longestValidParentheses(self, s: str) -> int:
        answer = 0
        stack = [-1]

        for i, p in enumerate(s):
            if p == '(':
                stack.append(i)
                continue
                
            stack.pop()
            if not stack:
                stack.append(i)
            else:
                answer = max(answer, i - stack[-1])
        
        return answer

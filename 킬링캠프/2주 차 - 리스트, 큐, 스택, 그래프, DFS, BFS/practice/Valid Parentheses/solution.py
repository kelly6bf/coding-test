class Solution:
    def isValid(self, s: str) -> bool:
        stack = []

        for p in s:
            if p == '(':
                stack.append(')')
            elif p == '{':
                stack.append('}')
            elif p == '[':
                stack.append(']')
            elif stack and stack[-1] == p:
                stack.pop()
            else:
                return False
        
        return not stack

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        answer = []
        self.back_tracking(s, answer, [], 0)

        return answer
    
    def back_tracking(self, s, answer, temp, start):
        if (start == len(s)):
            answer.append(temp[:])
            return

        for i in range(start, len(s)):
            target = s[start:i + 1]
            if (not self.is_palindrome(target)):
                continue
            
            temp.append(target)
            self.back_tracking(s, answer, temp, i + 1)
            temp.pop()
    
    def is_palindrome(self, target):
        return target == target[::-1]

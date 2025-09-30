class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []
        self.recursive(list(s), 0, [], result)
        return result

    def recursive(self, sArr, start, temp, result):
        if (start == len(sArr)):
            result.append(list(temp))
        
        s = ''
        for i in range(start, len(sArr)):
            s += sArr[i]
            if (not self.isPalindrome(s)):
                continue
            
            temp.append(s)
            self.recursive(sArr, i + 1, temp, result)
            temp.pop()
        
    def isPalindrome(self, s):
        return s == s[::-1]

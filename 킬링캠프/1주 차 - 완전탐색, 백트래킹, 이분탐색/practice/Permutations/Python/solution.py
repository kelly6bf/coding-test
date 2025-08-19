class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        ans = []
        self.recursive(nums, ans, [])

        return ans
    
    def recursive(self, nums, ans, temp):
        if (len(temp) == len(nums)):
            ans.append(temp[:])
            return

        for i in nums:
            if (i in temp):
                continue

            temp.append(i)
            self.recursive(nums, ans, temp)
            temp.pop()

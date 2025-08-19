class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ans = []
        self.recursive(nums, ans, [], 0)

        return ans
    
    def recursive(self, nums, ans, temp, start):
        if (temp not in ans):
            ans.append(temp[:])

        for i in range(start, len(nums)):
            temp.append(nums[i])
            self.recursive(nums, ans, temp, i + 1)
            temp.pop()

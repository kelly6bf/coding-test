class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        nums = [i for i in range(1, n + 1)]
        ans = []
        self.recursive(nums, k, ans, [], 0)

        return ans
    
    def recursive(self, nums, k, ans, temp, start):
        if (len(temp) == k):
            ans.append(temp[:])
            return

        for i in range(start, len(nums)):
            temp.append(nums[i])
            self.recursive(nums, k, ans, temp, i + 1)
            temp.pop()

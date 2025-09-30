class Solution:
    def search(self, nums: List[int], target: int) -> int:
        return self.recursive(nums, target, 0, len(nums) - 1)
    
    def recursive(self, nums, target, left, right):
        if (left > right):
            return -1
        
        mid = (left + right) // 2
        if (nums[mid] == target):
            return mid
        
        if (nums[mid] < target):
            return self.recursive(nums, target, mid + 1, right)
        else:
            return self.recursive(nums, target, left, mid - 1)

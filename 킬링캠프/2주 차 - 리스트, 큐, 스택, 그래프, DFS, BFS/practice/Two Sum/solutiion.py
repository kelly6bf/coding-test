class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        new_nums = [[nums[i], i] for i in range(len(nums))]
        new_nums.sort(key = lambda x: x[0])

        left = 0
        right = len(new_nums) - 1

        while (left < right):
            num1 = new_nums[left]
            num2 = new_nums[right]
            if (num1[0] + num2[0] == target):
                return [num1[1], num2[1]]
            elif (num1[0] + num2[0] < target):
                left += 1
            else:
                right -= 1

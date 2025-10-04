class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        nums = [i for i in range(1, n + 1)]
        return self.recursive(nums, k - 1, "")
    
    def recursive(self, nums, k, answer):
        if (len(nums) == 1):
            return answer + str(nums[0])
        
        case_count = self.calculate_factorial(len(nums) - 1)
        target = k // case_count
        answer += str(nums[target])
        nums.pop(target)

        return self.recursive(nums, k % case_count, answer)
    
    def calculate_factorial(self, n):
        result = 1
        for i in range(1, n + 1):
            result *= i
        
        return result

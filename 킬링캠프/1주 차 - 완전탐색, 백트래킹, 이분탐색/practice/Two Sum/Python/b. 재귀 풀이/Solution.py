class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        return self.recursive(nums, target, 0, [])
        
    def recursive(self, nums, target, start, temp):
        if (len(temp) == 2):
            if (nums[temp[0]] + nums[temp[1]] == target):
                return temp
            return None

        for i in range(start, len(nums)):
            temp.append(i)

            answer = self.recursive(nums, target, i + 1, temp)
            if (answer != None):
                return answer
            
            temp.pop()

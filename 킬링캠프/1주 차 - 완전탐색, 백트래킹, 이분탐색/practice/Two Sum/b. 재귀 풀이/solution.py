class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # 메서드
        def backTracking(temp, start):
            if len(temp) == 2:
                if nums[temp[0]] + nums[temp[1]] == target:
                    return temp[:]
                else:
                    return None

            for i in range(start, len(nums)):
                temp.append(i)
                result = backTracking(temp, i + 1)
                if result is not None:
                    return result
                
                temp.pop()

        # 메인 로직
        return backTracking([], 0)

class Solution:
    def trap(self, height: List[int]) -> int:
        answer = 0
        new_height = height[:]
        left = 0
        left_maximum = height[left]
        right = len(height) - 1
        right_maximum = height[right]

        while left < right:
            if left_maximum <= right_maximum:
                left += 1
                if height[left] < left_maximum:
                    new_height[left] = left_maximum
                else:
                    left_maximum = height[left]
            else:
                right -= 1
                if height[right] < right_maximum:
                    new_height[right] = right_maximum
                else:
                    right_maximum = height[right]
        
        for i in range(len(height)):
            answer += new_height[i] - height[i]
        
        return answer

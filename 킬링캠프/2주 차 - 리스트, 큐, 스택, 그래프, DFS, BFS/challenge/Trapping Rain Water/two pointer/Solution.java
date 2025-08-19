class Solution {
    public int trap(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        while (left < right) {
            if (leftMax <= rightMax) {
                left++;
                int currentHeight = height[left];
                if (currentHeight < leftMax) {
                    result += leftMax - currentHeight;
                } else {
                    leftMax = currentHeight;
                }
            } else {
                right--;
                int currentHeight = height[right];
                if (currentHeight < rightMax) {
                    result += rightMax - currentHeight;
                } else {
                    rightMax = currentHeight;
                }
            }
        }

        return result;
    }
}

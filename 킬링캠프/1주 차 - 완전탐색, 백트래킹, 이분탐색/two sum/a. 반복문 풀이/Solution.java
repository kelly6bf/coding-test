class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (isTarget(nums[i], nums[j], target)) {
                    return new int[] {i, j};
                }
            }
        }

        return null;
    }

    private boolean isTarget(int a, int b, int target) {
        return (a + b) == target;
    }
}

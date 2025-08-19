import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        return twoPointer(arr, target);
    }

    private int[] twoPointer(int[][] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int sum = nums[left][0] + nums[right][0];
            if (sum == target) {
                return new int[]{nums[left][1], nums[right][1]};
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return null;
    }
}

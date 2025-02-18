import java.util.*;

class Solution {

    public int[] twoSum(int[] nums, int target) {
        return recursive(nums, target, 0, new ArrayList<Integer>());
    }

    private int[] recursive(int[] nums, int target, int start, List<Integer> answer) {
        if (answer.size() == 2) {
            if (nums[answer.get(0)] + nums[answer.get(1)] == target) {
                return new int[]{answer.get(0), answer.get(1)};
            }

            return null;
        }

        for (int i = start; i < nums.length; i++) {
            answer.add(i);
            int[] result = recursive(nums, target, i + 1, answer);
            if (result != null) {
                return result;
            }
            answer.remove(answer.size() - 1);
        }

        return null;
    }
}

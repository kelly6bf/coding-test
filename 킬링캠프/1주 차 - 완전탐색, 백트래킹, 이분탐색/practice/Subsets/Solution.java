import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        backTracking(nums, 0, subset, answer);

        return answer;
    }

    private void backTracking(int[] nums, int start, List<Integer> subset, List<List<Integer>> answer) {
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            answer.add(new ArrayList<>(subset));
            backTracking(nums, i + 1, subset, answer);
            subset.remove(subset.size() - 1);
        }
    }
}

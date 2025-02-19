import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();
        recursive(nums, 0, answer, subSet);
        return answer;
    }

    private void recursive(int[] nums, int start, List<List<Integer>> answer, List<Integer> subSet) {
        answer.add(new ArrayList<>(subSet));

        for (int i = start; i < nums.length; i++) {
            subSet.add(nums[i]);
            recursive(nums, i + 1, answer, subSet);
            subSet.remove(subSet.size() - 1);
        }
    }
}

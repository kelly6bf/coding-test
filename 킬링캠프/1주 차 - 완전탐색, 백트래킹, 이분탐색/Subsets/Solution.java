import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(List.of());
        List<Integer> subSet = new ArrayList<>();
        recursive(nums, answer, subSet);

        return answer;
    }

    private void recursive(int[] nums, List<List<Integer>> answer, List<Integer> subSet) {
        if (subSet.size() == nums.length) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (subSet.contains(nums[i]) || (!subSet.isEmpty() && subSet.get(subSet.size() - 1) >= nums[i])) {
                continue;
            }

            subSet.add(nums[i]);
            answer.add(new ArrayList<>(subSet));

            recursive(nums, answer, subSet);
            
            subSet.remove(subSet.size() - 1);
        }
    }
}

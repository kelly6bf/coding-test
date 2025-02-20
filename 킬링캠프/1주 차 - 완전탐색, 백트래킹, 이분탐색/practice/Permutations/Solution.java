import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        recursive(nums, answer, permutation);

        return answer;
    }

    private void recursive(int[] nums, List<List<Integer>> answer, List<Integer> permutation) {
        if (permutation.size() == nums.length) {
            answer.add(new ArrayList<>(permutation));
            return;
        }

        for (int i : nums) {
            if (permutation.contains(i)) {
                continue;
            }

            permutation.add(i);
            recursive(nums, answer, permutation);
            permutation.remove(permutation.size() - 1);
        }
    }
}

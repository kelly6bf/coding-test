import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        recursive(n, k, 1, answer, combination);

        return answer;
    }

    private void recursive(int n, int k, int start, List<List<Integer>> answer, List<Integer> combination) {
        if (combination.size() == k) {
            answer.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i <= n; i++) {
            combination.add(i);
            recursive(n, k, i + 1, answer, combination);
            combination.remove(combination.size() - 1);
        }
    }
}

import java.util.*;

class Solution {

    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        return backTracking(n, k - 1, 1, numbers, "");
    }

    private String backTracking(int n, int k, int count, List<Integer> numbers, String permutation) {
        if (numbers.isEmpty()) {
            return permutation;
        }

        int offset = calculateFactorial(n - count);
        int target = k / offset;
        List<Integer> nextNumbers = new ArrayList<>(numbers);
        nextNumbers.remove(target);

        return backTracking(n, k % offset, count += 1, nextNumbers, permutation += String.valueOf(numbers.get(target)));
    }

    private int calculateFactorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}

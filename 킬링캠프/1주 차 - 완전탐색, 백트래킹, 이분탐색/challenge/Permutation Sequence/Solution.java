import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        
        return backTracking(n, k - 1, nums, new StringBuilder());
    }

    private String backTracking(int n, int k, List<Integer> nums, StringBuilder sb) {
        if (nums.size() == 1) {
            return sb.append(nums.get(0)).toString();
        }

        int seqCount = calculateFactorial(n - 1);
        int target = k / seqCount;

        sb.append(nums.get(target));
        nums.remove(target);
        return backTracking(n - 1, k % seqCount, nums, sb);
    }

    private int calculateFactorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}

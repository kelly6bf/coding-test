import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        String[] sArr = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            sArr[i] = String.valueOf(s.charAt(i));
        }
        List<List<String>> result = new ArrayList<>();

        backTracking(sArr, 0, result, new ArrayList<>());
        return result;
    }

    private void backTracking(String[] sArr, int step, List<List<String>> result, List<String> strs) {
        if (step == sArr.length) {
            if (isPalindromes(strs)) {
                result.add(new ArrayList<>(strs));
            }
            return;
        }

        String str = "";
        for (int i = step; i < sArr.length; i++) {
            str += sArr[i];
            strs.add(str);
            backTracking(sArr, i + 1, result, strs);

            strs.remove(strs.size() - 1);
        }
    }

    private boolean isPalindromes(List<String> strs) {
        for (String s : strs) {
            if (!s.equals(new StringBuilder(s).reverse().toString())) {
                return false;
            }
        }

        return true;
    }
}

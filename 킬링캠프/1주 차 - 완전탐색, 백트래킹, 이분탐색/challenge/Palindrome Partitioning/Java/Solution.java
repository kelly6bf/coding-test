import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        String[] sArr = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            sArr[i] = String.valueOf(s.charAt(i));
        }
        backTracking(sArr, result, 0, new ArrayList<>());
        return result;
    }

    private void backTracking(String[] sArr, List<List<String>> result, int start, List<String> subStr) {
        if (start == sArr.length) {
            if (isPalindrome(subStr)) {
                result.add(new ArrayList<>(subStr));
            }
            return;
        }

        String s = "";
        for (int i = start; i < sArr.length; i++) {
            s += sArr[i];
            subStr.add(s);
            backTracking(sArr, result, i + 1, subStr);
            subStr.remove(subStr.size() - 1);
        }
    }

    private boolean isPalindrome(List<String> subStr) {
        for (String str : subStr) {
            if (!str.equals(new StringBuilder(str).reverse().toString())) {
                return false;
            }
        }

        return true;
    }
}

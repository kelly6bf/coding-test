import java.util.*;

class Solution {
    public int longestValidParentheses(String s) {
        char[] sArr = s.toCharArray();
        Deque<Element> dq = new ArrayDeque<>();
        int result = 0;
        for (int i = 0; i < sArr.length; i++) {
            char currentValue = sArr[i];
            if (!dq.isEmpty() && (dq.peek().value == '(' && currentValue == ')')) {
                dq.pop();
                if (dq.isEmpty()) {
                    result = Math.max(result, i + 1);
                } else {
                    result = Math.max(result, i - dq.peek().index);
                }
                
                continue;
            }

            dq.push(new Element(i, currentValue));
        }

        return result;
    }
}

class Element {
    int index;
    char value;

    Element(int index, char value) {
        this.index = index;
        this.value = value;
    }
}

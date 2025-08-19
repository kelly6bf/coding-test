import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> dq = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(': dq.push(')'); break;
                case '{': dq.push('}'); break;
                case '[': dq.push(']'); break;
                default:
                    if (!dq.isEmpty() && dq.peek() == c) {
                        dq.pop();
                    } else {
                        return false;
                    }
            }
        }
        
        return dq.isEmpty();
    }
}

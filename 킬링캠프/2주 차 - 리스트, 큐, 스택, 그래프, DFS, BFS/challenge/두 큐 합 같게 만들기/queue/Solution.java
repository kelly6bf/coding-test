import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Deque<Integer> dq1 = new ArrayDeque<>();
        long dq1Sum = 0;
        for (int num : queue1) {
            dq1.offer(num);
            dq1Sum += num;
        }

        Deque<Integer> dq2 = new ArrayDeque<>();
        long dq2Sum = 0;
        for (int num : queue2) {
            dq2.offer(num);
            dq2Sum += num;
        }

        if ((dq1Sum + dq2Sum) % 2 != 0) {
            return -1;
        }

        int n = queue1.length;
        int count = 0;
        for (int i = 0; i < 3 * n; i++) {
            if (dq1Sum == dq2Sum) {
                return count;
            }

            if (dq1Sum < dq2Sum) {
                int moveNumber = dq2.poll();
                dq1.offer(moveNumber);
                dq1Sum += moveNumber;
                dq2Sum -= moveNumber;
            } else {
                int moveNumber = dq1.poll();
                dq2.offer(moveNumber);
                dq2Sum += moveNumber;
                dq1Sum -= moveNumber;
            }
            
            count++;
        }

        return -1;
    }

    private long calculateSum(Deque<Integer> dq) {
        long result = 0;
        for (int num : dq) {
            result += num;
        }

        return result;
    }
}

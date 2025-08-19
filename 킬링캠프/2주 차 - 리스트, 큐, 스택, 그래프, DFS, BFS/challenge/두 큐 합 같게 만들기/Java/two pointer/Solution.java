class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        int[] queue = new int[queue1.length + queue2.length];
        System.arraycopy(queue1, 0, queue, 0, queue1.length);
        System.arraycopy(queue2, 0, queue, n, queue2.length);

        long target = (calculateSum(queue1) + calculateSum(queue2)) / 2;
        long queue1Sum = calculateSum(queue1);

        int left = 0;
        int right = queue1.length;
        for (int answer = 0; answer < 3 * n; answer++) {
            if (queue1Sum == target) {
                return answer;
            }

            if (queue1Sum > target) {
                queue1Sum -= queue[left];
                left = (left + 1) % queue.length;
            } else {
                queue1Sum += queue[right];
                right = (right + 1) % queue.length;
            }
        }

        return -1;
    }

    private long calculateSum(int[] queue) {
        long result = 0;
        for (int value : queue) {
            result += value;
        }

        return result;
    }
}

import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Temp> dq = new ArrayDeque<>();
        for (int day = 0; day < temperatures.length; day++) {
            int currentTemp = temperatures[day];
            while (!dq.isEmpty() && dq.peek().value < currentTemp) {
                Temp target = dq.pop();
                result[target.day] = day - target.day;
            }
            dq.push(new Temp(day, currentTemp));
        }

        for (Temp temp : dq) {
            result[temp.day] = 0;
        }

        return result;
    }
}

class Temp {
    int day;
    int value;

    Temp(int day, int value) {
        this.day = day;;
        this.value = value;
    }
}

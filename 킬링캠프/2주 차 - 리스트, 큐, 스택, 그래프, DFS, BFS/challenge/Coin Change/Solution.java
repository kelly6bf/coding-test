import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        return bfs(coins, amount);
    }

    private int bfs(int[] coins, int amount) {
        boolean[] visited = new boolean[amount + 1];
        Deque<Vertex> dq = new ArrayDeque<>();
        dq.offer(new Vertex(amount, 0));
        visited[amount] = true;

        while (!dq.isEmpty()) {
            Vertex currentVertex = dq.poll();

            for (int coin : coins) {
                int nextAmount = currentVertex.amount - coin;
                int nextCoinCount = currentVertex.coinCount + 1;
                if (nextAmount == 0) {
                    return nextCoinCount;
                }

                if (nextAmount > 0 && !visited[nextAmount]) {
                    dq.offer(new Vertex(nextAmount, nextCoinCount));
                    visited[nextAmount] = true;
                }
            }
        }

        return -1;
    }
}

class Vertex {
    int amount;
    int coinCount;

    Vertex(int amount, int coinCount) {
        this.amount = amount;
        this.coinCount = coinCount;
    }
}

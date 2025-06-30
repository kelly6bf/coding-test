import java.util.*;

class Solution {
    public int trap(int[] height) {
        int[] trapped = height.clone();
        Deque<Block> dq = new ArrayDeque<>();
        Block poped = new Block(0, 0);
        for (int i = 0; i < height.length; i++) {
            int h = height[i];
            while (!dq.isEmpty() && dq.peek().height <= h) {
                poped = dq.pop();
            }

            Block left;
            if (!dq.isEmpty()) {
                left = dq.peek();
                for (int j = left.index + 1; j < i; j++) {
                    trapped[j] = h;
                }
            } else {
                left = poped;
                for (int j = left.index + 1; j < i; j++) {
                    trapped[j] = left.height;
                }
            }

            dq.push(new Block(i, h));
        }

        int result = 0;
        for (int i = 0; i < height.length; i++) {
            result += (trapped[i] - height[i]);
        }

        return result;
    }
}

class Block {
    int index;
    int height;

    Block(int index, int height) {
        this.index = index;
        this.height = height;
    }
}

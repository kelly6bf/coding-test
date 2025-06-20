import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        List<Set<Integer>> candidateKeys = new ArrayList<>();
        int rowSize = relation.length;
        int colSize = relation[0].length;

        for (int keyCount = 1; keyCount <= colSize; keyCount++) {
            List<Set<Integer>> keyCombi = new ArrayList<>();
            getCombi(colSize, keyCombi, new HashSet<>(), keyCount, 0);

            outer: for (Set<Integer> key : keyCombi) {
                for (Set<Integer> candidateKey : candidateKeys) {
                    if (key.containsAll(candidateKey)) {
                        continue outer;
                    }
                }

                Set<String> data = new HashSet<>();
                for (int row = 0; row < rowSize; row++) {
                    StringBuilder sb = new StringBuilder();
                    for (int col : key) {
                        sb.append(relation[row][col]).append("|");
                    }
                    data.add(sb.toString());
                }

                if (data.size() == rowSize) {
                    candidateKeys.add(key);
                }
            }
        }

        return candidateKeys.size();
    }

    private void getCombi(int totalKeyCount, List<Set<Integer>> combi, Set<Integer> keys, int maxCount, int start) {
        if (keys.size() == maxCount) {
            combi.add(new HashSet<>(keys));
        }

        for (int i = start; i < totalKeyCount; i++) {
            keys.add(i);
            getCombi(totalKeyCount, combi, keys, maxCount, i + 1);
            keys.remove(i);
        }
    }
}

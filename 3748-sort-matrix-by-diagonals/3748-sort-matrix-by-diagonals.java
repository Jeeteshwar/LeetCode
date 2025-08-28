import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        Map<Integer, List<Integer>> diagMap = new HashMap<>();

        // Collect all diagonals
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                diagMap.putIfAbsent(key, new ArrayList<>());
                diagMap.get(key).add(grid[i][j]);
            }
        }

        // Sort diagonals
        for (int key : diagMap.keySet()) {
            List<Integer> list = diagMap.get(key);
            if (key >= 0) { // bottom-left including main diagonal
                list.sort(Collections.reverseOrder()); // non-increasing
            } else { // top-right
                Collections.sort(list); // non-decreasing
            }
        }

        // Place back values
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                int idx = indexMap.getOrDefault(key, 0);
                grid[i][j] = diagMap.get(key).get(idx);
                indexMap.put(key, idx + 1);
            }
        }

        return grid;
    }
}

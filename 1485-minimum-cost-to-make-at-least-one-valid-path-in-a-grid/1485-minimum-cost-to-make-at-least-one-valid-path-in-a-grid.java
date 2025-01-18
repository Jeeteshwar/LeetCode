import java.util.*;

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Directions: right, left, down, up
        int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0])); // Min-heap
        int[][] result = new int[m][n];
        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Start with the first cell
        pq.offer(new int[]{0, 0, 0}); // {cost, row, col}
        result[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currCost = curr[0];
            int i = curr[1];
            int j = curr[2];

            // If the current cost is greater than the minimum cost to this cell, skip it
            if (result[i][j] < currCost) {
                continue;
            }

            for (int dirIndex = 0; dirIndex < 4; dirIndex++) {
                int ni = i + DIR[dirIndex][0];
                int nj = j + DIR[dirIndex][1];

                // Check boundaries
                if (ni >= 0 && nj >= 0 && ni < m && nj < n) {
                    int gridDir = grid[i][j];
                    int dirCost = (gridDir - 1 != dirIndex) ? 1 : 0;
                    int newCost = currCost + dirCost;

                    // Update if a cheaper cost is found
                    if (newCost < result[ni][nj]) {
                        result[ni][nj] = newCost;
                        pq.offer(new int[]{newCost, ni, nj});
                    }
                }
            }
        }

        // Return the minimum cost to reach the bottom-right cell
        return result[m - 1][n - 1];
    }
}

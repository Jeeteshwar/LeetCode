

class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Initialize the result matrix with maximum values
        int[][] result = new int[m][n];
        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        result[0][0] = 0; // Starting cell has no obstacles to remove

        // Priority queue to process cells in order of obstacle count
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0}); // {obstacleCount, row, col}

        // Directions for moving in the grid: right, left, down, up
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int obstacleCount = current[0];
            int i = current[1];
            int j = current[2];

            // If we already found a shorter path to this cell, skip
            if (obstacleCount > result[i][j]) {
                continue;
            }

            // Explore neighbors
            for (int[] dir : directions) {
                int x = i + dir[0];
                int y = j + dir[1];

                // Check if the neighbor is within bounds
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    int wt = (grid[x][y] == 1) ? 1 : 0; // Weight is 1 if there's an obstacle, 0 otherwise

                    // Update the result matrix and priority queue if a shorter path is found
                    if (obstacleCount + wt < result[x][y]) {
                        result[x][y] = obstacleCount + wt;
                        pq.offer(new int[]{obstacleCount + wt, x, y});
                    }
                }
            }
        }

        // Return the minimum obstacles to reach the bottom-right corner
        return result[m - 1][n - 1];
    }
}

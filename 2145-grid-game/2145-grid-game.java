class Solution {
    public long gridGame(int[][] grid) {
        long upperRowSum = 0;
        for (int num : grid[0]) {
            upperRowSum += num;  // O(col)
        }

        long lowerRowSum = 0;
        long minimizedSecondRobotSum = Long.MAX_VALUE;

        for (int col = 0; col < grid[0].length; col++) {  // O(col)
            // First robot moves in this column
            upperRowSum -= grid[0][col];

            // Second robot takes the optimal strategy after the first robot's move
            long maxSecondRobotSum = Math.max(upperRowSum, lowerRowSum);

            minimizedSecondRobotSum = Math.min(minimizedSecondRobotSum, maxSecondRobotSum);

            lowerRowSum += grid[1][col];
        }

        return minimizedSecondRobotSum;
    }
}

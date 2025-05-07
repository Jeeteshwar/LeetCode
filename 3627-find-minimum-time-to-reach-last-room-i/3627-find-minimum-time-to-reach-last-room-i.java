import java.util.*;

class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int rows = moveTime.length, cols = moveTime[0].length;
        int[][] minTime = new int[rows][cols];
        for (int[] row : minTime) Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, 0, 0}); // {currentTime, row, col}
        moveTime[0][0] = 0;

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentTime = current[0];
            int row = current[1];
            int col = current[2];

            if (currentTime >= minTime[row][col]) continue;
            if (row == rows - 1 && col == cols - 1) return currentTime;

            minTime[row][col] = currentTime;

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols &&
                    minTime[newRow][newCol] == Integer.MAX_VALUE) {

                    int waitTime = Math.max(moveTime[newRow][newCol], currentTime) + 1;
                    pq.add(new int[]{waitTime, newRow, newCol});
                }
            }
        }

        return -1; // Should not reach here with valid input
    }
}

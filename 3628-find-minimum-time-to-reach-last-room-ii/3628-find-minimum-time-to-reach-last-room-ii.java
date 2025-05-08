class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int rows = moveTime.length, cols = moveTime[0].length;
        int INF = Integer.MAX_VALUE;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(dp[i], INF);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, 0, 0});
        moveTime[0][0] = 0;

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentTime = current[0];
            int currentRow  = current[1];
            int currentCol  = current[2];
            if (currentTime >= dp[currentRow][currentCol]) continue;
            if (currentRow == rows - 1 && currentCol == cols - 1) return currentTime;
            dp[currentRow][currentCol] = currentTime;

            for (int[] dir : directions) {
                int nextRow = currentRow + dir[0];
                int nextCol = currentCol + dir[1];
                if (nextRow >= 0 && nextRow < rows &&
                    nextCol >= 0 && nextCol < cols &&
                    dp[nextRow][nextCol] == INF) {
                    int moveCost  = (currentRow + currentCol) % 2 + 1;
                    int startTime = Math.max(moveTime[nextRow][nextCol], currentTime);
                    int nextTime = startTime + moveCost;
                    pq.add(new int[]{nextTime, nextRow, nextCol});
                }
            }
        }
        return -1;
    }
}

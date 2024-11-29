import java.util.PriorityQueue;

class Solution {
    private static final int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

    public int minimumTime(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;

        boolean[][] visited = new boolean[m][n];
        int[][] minTime = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                minTime[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[] {0, 0, 0}); // {time, row, col}
        minTime[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], row = curr[1], col = curr[2];

            if (row == m - 1 && col == n - 1) return time;
            if (visited[row][col]) continue;

            visited[row][col] = true;

            for (int[] dir : directions) {
                int newRow = row + dir[0], newCol = col + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    int nextTime = calculateNextTime(time, grid[newRow][newCol]);

                    if (nextTime < minTime[newRow][newCol]) {
                        minTime[newRow][newCol] = nextTime;
                        pq.add(new int[] {nextTime, newRow, newCol});
                    }
                }
            }
        }

        return -1;
    }

    private int calculateNextTime(int currentTime, int cellTime) {
        if (cellTime <= currentTime + 1) {
            return currentTime + 1;
        } else if ((cellTime - currentTime) % 2 == 0) {
            return cellTime + 1;
        } else {
            return cellTime;
        }
    }
}

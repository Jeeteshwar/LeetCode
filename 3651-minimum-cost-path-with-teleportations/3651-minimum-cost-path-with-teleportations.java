import java.util.*;

class Solution {
    public int minCost(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int MAX_VAL = 10000;
        
        // Group cells by value
        List<int[]>[] cellsByValue = new List[MAX_VAL + 1];
        for (int v = 0; v <= MAX_VAL; v++) {
            cellsByValue[v] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cellsByValue[grid[i][j]].add(new int[]{i, j});
            }
        }
        
        int INF = Integer.MAX_VALUE / 2;
        int[][][] dist = new int[m][n][k + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], INF);
            }
        }
        dist[0][0][0] = 0;
        
        // maxProcessedValue[t]
        int[] maxProcessedValue = new int[k + 1];
        Arrays.fill(maxProcessedValue, -1);
        
        // Dijkstra: (cost, i, j, t)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0], i = cur[1], j = cur[2], t = cur[3];
            
            if (cost > dist[i][j][t]) continue;
            
            // Normal moves
            // Right
            if (j + 1 < n) {
                int ni = i, nj = j + 1;
                int newCost = cost + grid[ni][nj];
                if (newCost < dist[ni][nj][t]) {
                    dist[ni][nj][t] = newCost;
                    pq.offer(new int[]{newCost, ni, nj, t});
                }
            }
            // Down
            if (i + 1 < m) {
                int ni = i + 1, nj = j;
                int newCost = cost + grid[ni][nj];
                if (newCost < dist[ni][nj][t]) {
                    dist[ni][nj][t] = newCost;
                    pq.offer(new int[]{newCost, ni, nj, t});
                }
            }
            
            // Teleport
            if (t < k && grid[i][j] > maxProcessedValue[t]) {
                // Process all values from maxProcessedValue[t]+1 to grid[i][j]
                for (int v = maxProcessedValue[t] + 1; v <= grid[i][j]; v++) {
                    for (int[] cell : cellsByValue[v]) {
                        int x = cell[0], y = cell[1];
                        if (dist[x][y][t + 1] > cost) {
                            dist[x][y][t + 1] = cost;
                            pq.offer(new int[]{cost, x, y, t + 1});
                        }
                    }
                }
                maxProcessedValue[t] = grid[i][j];
            }
        }
        
        int ans = INF;
        for (int t = 0; t <= k; t++) {
            ans = Math.min(ans, dist[m - 1][n - 1][t]);
        }
        return ans;
    }
}
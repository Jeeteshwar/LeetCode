class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // 行前缀和
        int[][] rowSum = new int[m][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i][j + 1] = rowSum[i][j] + grid[i][j];
            }
        }
        
        // 列前缀和
        int[][] colSum = new int[m + 1][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                colSum[i + 1][j] = colSum[i][j] + grid[i][j];
            }
        }
        
        // 从大到小枚举 k
        for (int k = Math.min(m, n); k >= 2; k--) {
            for (int i = 0; i + k <= m; i++) {
                for (int j = 0; j + k <= n; j++) {
                    if (isMagic(grid, i, j, k, rowSum, colSum)) {
                        return k;
                    }
                }
            }
        }
        return 1; // 至少是 1
    }
    
    private boolean isMagic(int[][] grid, int r, int c, int k, int[][] rowSum, int[][] colSum) {
        // 检查第一行的和作为 target
        int target = rowSum[r][c + k] - rowSum[r][c];
        
        // 检查各行
        for (int i = r; i < r + k; i++) {
            if (rowSum[i][c + k] - rowSum[i][c] != target) {
                return false;
            }
        }
        
        // 检查各列
        for (int j = c; j < c + k; j++) {
            if (colSum[r + k][j] - colSum[r][j] != target) {
                return false;
            }
        }
        
        // 主对角线
        int diag1 = 0;
        for (int d = 0; d < k; d++) {
            diag1 += grid[r + d][c + d];
        }
        if (diag1 != target) return false;
        
        // 副对角线
        int diag2 = 0;
        for (int d = 0; d < k; d++) {
            diag2 += grid[r + d][c + k - 1 - d];
        }
        if (diag2 != target) return false;
        
        return true;
    }
}
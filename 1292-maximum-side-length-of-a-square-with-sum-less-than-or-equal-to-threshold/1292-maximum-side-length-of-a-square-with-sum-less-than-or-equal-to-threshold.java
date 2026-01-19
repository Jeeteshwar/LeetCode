class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        
        // 1. Compute 2D prefix sum
        int[][] prefix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = mat[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }
        
        // 2. Binary search on side length
        int low = 0, high = Math.min(m, n);
        int ans = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (existsSquare(mid, prefix, threshold, m, n)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    
    private boolean existsSquare(int k, int[][] prefix, int threshold, int m, int n) {
        if (k == 0) return true;
        for (int i = k; i <= m; i++) {
            for (int j = k; j <= n; j++) {
                // bottom-right corner (i, j), top-left corner (i-k, j-k) in 1-based prefix
                int sum = prefix[i][j] - prefix[i - k][j] - prefix[i][j - k] + prefix[i - k][j - k];
                if (sum <= threshold) return true;
            }
        }
        return false;
    }
}
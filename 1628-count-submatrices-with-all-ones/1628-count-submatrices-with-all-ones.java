class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] heights = new int[m][n];
        
        // Build histogram heights row by row
        for (int j = 0; j < n; j++) {
            heights[0][j] = mat[0][j];
            for (int i = 1; i < m; i++) {
                if (mat[i][j] == 1) {
                    heights[i][j] = heights[i-1][j] + 1;
                } else {
                    heights[i][j] = 0;
                }
            }
        }
        
        int count = 0;
        
        // For each row, calculate rectangles ending at that row
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (heights[i][j] > 0) {
                    int minHeight = heights[i][j];
                    for (int k = j; k >= 0; k--) {
                        if (heights[i][k] == 0) break;
                        minHeight = Math.min(minHeight, heights[i][k]);
                        count += minHeight;
                    }
                }
            }
        }
        
        return count;
    }
}

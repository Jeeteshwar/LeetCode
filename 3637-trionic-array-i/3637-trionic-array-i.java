class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4) return false;
        
        boolean[] incFromLeft = new boolean[n];
        boolean[] incFromRight = new boolean[n];
        
        incFromLeft[0] = true;
        for (int i = 1; i < n; i++) {
            incFromLeft[i] = incFromLeft[i-1] && (nums[i] > nums[i-1]);
        }
        
        incFromRight[n-1] = true;
        for (int i = n-2; i >= 0; i--) {
            incFromRight[i] = incFromRight[i+1] && (nums[i] < nums[i+1]);
        }
        
        // decFrom[i][j] = strictly decreasing from i to j inclusive
        boolean[][] decFrom = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            decFrom[i][i] = true;
            for (int j = i+1; j < n; j++) {
                decFrom[i][j] = decFrom[i][j-1] && (nums[j-1] > nums[j]);
            }
        }
        
        for (int p = 1; p <= n-3; p++) {
            for (int q = p+1; q <= n-2; q++) {
                if (incFromLeft[p] && decFrom[p][q] && incFromRight[q]) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
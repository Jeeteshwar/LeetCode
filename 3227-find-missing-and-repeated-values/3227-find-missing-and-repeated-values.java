class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length; // grid is n x n
        int totalSize = n * n;
        
        // Create array to track frequency of numbers (1-based indexing)
        int[] freq = new int[totalSize + 1];
        
        // Fill frequency array
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                freq[grid[i][j]]++;
            }
        }
        
        int repeated = 0;
        int missing = 0;
        
        // Find repeated and missing numbers
        for(int i = 1; i <= totalSize; i++) {
            if(freq[i] == 2) {
                repeated = i;
            }
            if(freq[i] == 0) {
                missing = i;
            }
        }
        
        return new int[]{repeated, missing};
    }
}
class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        Integer[][][] memo = new Integer[grid.length][grid[0].length][k];
        return numberOfPaths(grid, 0, 0, 0, k, memo);
    }

    private static final int MOD = 1_000_000_007;

    // Returns the number of paths to (row, col), where the sum modulo k == `currentRemainder`
    private int numberOfPaths(int[][] grid, int row, int col, int currentRemainder, int k, Integer[][][] memo) {
        if (row == grid.length || col == grid[0].length)
            return 0;
        if (row == grid.length - 1 && col == grid[0].length - 1)
            return (currentRemainder + grid[row][col]) % k == 0 ? 1 : 0;
        if (memo[row][col][currentRemainder] != null)
            return memo[row][col][currentRemainder];
        
        final int newRemainder = (currentRemainder + grid[row][col]) % k;
        return memo[row][col][currentRemainder] = (numberOfPaths(grid, row + 1, col, newRemainder, k, memo) +
                             numberOfPaths(grid, row, col + 1, newRemainder, k, memo)) %
                            MOD;
    }
}
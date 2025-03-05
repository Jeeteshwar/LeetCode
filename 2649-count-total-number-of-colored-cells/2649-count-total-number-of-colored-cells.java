class Solution {
    public long coloredCells(int n) {
        // For n minutes, the pattern is:
        // 1 cell initially plus 4 cells for each subsequent minute
        // This simplifies to n² + (n-1)²
        
        long nLong = (long)n; // Convert to long to avoid integer overflow
        long result = nLong * nLong + (nLong - 1) * (nLong - 1);
        return result;
        
        // Alternative mathematical formula: 2n² - 2n + 1
        // return 2 * nLong * nLong - 2 * nLong + 1;
    }
}
class Solution {
    public int numTilings(int n) {
        long MOD = 1_000_000_007;
        long[] f = new long[Math.max(4, n + 1)]; // Fully tiled
        long[] p = new long[Math.max(4, n + 1)]; // Partially tiled
        
        // Base cases
        f[0] = 1; // Empty board
        f[1] = 1;
        f[2] = 2;
        p[0] = 0;
        p[1] = 1;
        p[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            f[i] = (f[i-1] + f[i-2] + 2 * p[i-2]) % MOD;
            p[i] = (p[i-1] + f[i-1]) % MOD;
        }
        
        return (int) f[n];
    }
}
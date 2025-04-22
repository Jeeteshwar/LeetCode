class Solution {
    final int MOD = (int)1e9 + 7;

    void dfs(int val, int[] cnt, int[][] dp) {
        if (dp[val][1] != 0) return;

        dp[val][1] = 1;
        cnt[1]++;

        for (int d = 2; d <= val; d++) {
            if (val % d == 0) {
                dfs(val / d, cnt, dp);

                for (int l = 1; l < 15; l++) {
                    if (dp[val / d][l] != 0) {
                        dp[val][l + 1] = (dp[val][l + 1] + dp[val / d][l]) % MOD;
                        cnt[l + 1] = (cnt[l + 1] + dp[val / d][l]) % MOD;
                    }
                }
            }
        }
    }

    long power(long a, long b) {
        if (b == 0) return 1;
        long p = power(a, b / 2);
        p = (p * p) % MOD;
        if (b % 2 == 1) p = (p * a) % MOD;
        return p;
    }

    int nCr(int n, int r, long[] fact) {
        if (r < 0 || r > n) return 0;
        long den = (fact[r] * fact[n - r]) % MOD;
        return (int)((fact[n] * power(den, MOD - 2)) % MOD);
    }

    public int idealArrays(int n, int maxVal) {
        int[][] dp = new int[maxVal + 1][15];
        int[] cnt = new int[15];

        for (int val = 1; val <= maxVal; val++) {
            dfs(val, cnt, dp);
        }

        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        long res = 0;
        for (int len = 1; len < 15; len++) {
            if (n < len) break;
            if (cnt[len] != 0) {
                long ways = nCr(n - 1, len - 1, fact);
                res = (res + (cnt[len] * ways) % MOD) % MOD;
            }
        }

        return (int)res;
    }
}

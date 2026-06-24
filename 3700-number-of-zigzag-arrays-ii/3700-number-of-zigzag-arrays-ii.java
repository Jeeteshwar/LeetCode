class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {

        int m = r - l + 1;
        int sz = 2 * m;

        long[][] T = new long[sz][sz];

        // U[x] -> index x-1
        // D[x] -> index m + (x-1)

        for (int x = 1; x <= m; x++) {

            int ux = x - 1;
            int dx = m + x - 1;

            for (int y = 1; y < x; y++) {
                int dy = m + y - 1;
                T[ux][dy] = 1;
            }

            for (int y = x + 1; y <= m; y++) {
                int uy = y - 1;
                T[dx][uy] = 1;
            }
        }

        long[] base = new long[sz];

        // length = 2
        for (int x = 1; x <= m; x++) {
            base[x - 1] = x - 1;          // U[x]
            base[m + x - 1] = m - x;      // D[x]
        }

        long[] result;

        if (n == 2) {
            result = base;
        } else {
            long[][] P = power(T, n - 2);
            result = multiply(P, base);
        }

        long ans = 0;
        for (long v : result) {
            ans = (ans + v) % MOD;
        }

        return (int) ans;
    }

    private long[][] power(long[][] A, long exp) {
        int n = A.length;

        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, A);
            }

            A = multiply(A, A);
            exp >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;

        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {

                if (A[i][k] == 0) continue;

                long a = A[i][k];

                for (int j = 0; j < n; j++) {

                    if (B[k][j] == 0) continue;

                    C[i][j] = (C[i][j] + a * B[k][j]) % MOD;
                }
            }
        }

        return C;
    }

    private long[] multiply(long[][] A, long[] v) {
        int n = A.length;

        long[] res = new long[n];

        for (int i = 0; i < n; i++) {

            long cur = 0;

            for (int j = 0; j < n; j++) {
                cur = (cur + A[i][j] * v[j]) % MOD;
            }

            res[i] = cur;
        }

        return res;
    }
}
class Solution {
    // Modulo constant
    int MOD = 1_000_000_007;

    // Factorials array
    static int[] factorial = new int[100001];

    public int countGoodArrays(int n, int m, int k) {
        if (factorial[0] == 0)
            factorial[0] = 1;

        // result = m * (m-1)^(n-1-k) * C(n-1, n-1-k) % MOD
        long result = m;
        result = result * modPow(m - 1, n - 1 - k) % MOD;
        result = result * nCr(n - 1, n - 1 - k) % MOD;

        return (int) result;
    }

    // Fast exponentiation: (base^exp) % MOD
    private long modPow(int base, int exp) {
        long result = 1;
        long b = base;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = result * b % MOD;
            b = b * b % MOD;
            exp >>= 1;
        }
        return result;
    }

    // Computes nCr % MOD
    private long nCr(int n, int r) {
        return (long) getFactorial(n) * modInverse(getFactorial(r)) % MOD * modInverse(getFactorial(n - r)) % MOD;
    }

    // Computes factorial[n] with memoization
    private long getFactorial(int n) {
        if (factorial[n] != 0)
            return factorial[n];
        return factorial[n] = (int) (getFactorial(n - 1) * (long) n % MOD);
    }

    // Modular inverse using Fermat's Little Theorem: a^(-1) ≡ a^(MOD-2) mod MOD
    private long modInverse(long a) {
        if (a == 1)
            return 1;
        return MOD - MOD / a * modInverse(MOD % a) % MOD;
    }
}

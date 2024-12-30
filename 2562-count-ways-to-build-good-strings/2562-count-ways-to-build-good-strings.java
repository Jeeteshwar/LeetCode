class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        final int MOD = 1_000_000_007;

        // dp[i] will store the number of good strings of length i
        int[] dp = new int[high + 1];

        // Base case: There's 1 way to make an empty string
        dp[0] = 1;

        // Iterate over all lengths from 1 to high
        for (int length = 1; length <= high; length++) {
            // If we append '0' zero times, we reduce the length by `zero`
            if (length >= zero) {
                dp[length] = (dp[length] + dp[length - zero]) % MOD;
            }

            // If we append '1' one times, we reduce the length by `one`
            if (length >= one) {
                dp[length] = (dp[length] + dp[length - one]) % MOD;
            }
        }

        // Sum up all dp[i] for lengths in the range [low, high]
        int result = 0;
        for (int length = low; length <= high; length++) {
            result = (result + dp[length]) % MOD;
        }

        return result;
    }
}

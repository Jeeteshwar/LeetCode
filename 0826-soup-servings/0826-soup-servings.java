class Solution {
    private Double[][] memo;

    public double soupServings(int n) {
        if (n > 5000) return 1.0; // Cutoff optimization
        
        n = (int) Math.ceil(n / 25.0); // Scale down to units
        memo = new Double[n + 1][n + 1];
        return dp(n, n);
    }

    private double dp(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;
        if (memo[a][b] != null) return memo[a][b];

        double ans = 0.25 * (dp(a - 4, b) +
                             dp(a - 3, b - 1) +
                             dp(a - 2, b - 2) +
                             dp(a - 1, b - 3));
        return memo[a][b] = ans;
    }
}

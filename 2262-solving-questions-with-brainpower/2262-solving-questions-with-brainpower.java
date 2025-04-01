class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1]; // dp[i] is the max points from question i to n-1
        
        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int skip = questions[i][1];
            int next = i + skip + 1;
            long take = points + (next < n ? dp[next] : 0);
            long notTake = dp[i + 1];
            dp[i] = Math.max(take, notTake);
        }
        
        return dp[0];
    }
}
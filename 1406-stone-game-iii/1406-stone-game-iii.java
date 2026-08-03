class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        
        // dp[i] = maximum score difference (current player - opponent) 
        // starting from index i
        
        // Base case: no stones left
        dp[n] = 0;
        
        // Fill from right to left
        for (int i = n - 1; i >= 0; i--) {
            int takeOne = stoneValue[i] - dp[i + 1];
            
            int takeTwo = Integer.MIN_VALUE;
            if (i + 1 < n) {
                takeTwo = stoneValue[i] + stoneValue[i + 1] - dp[i + 2];
            }
            
            int takeThree = Integer.MIN_VALUE;
            if (i + 2 < n) {
                takeThree = stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp[i + 3];
            }
            
            dp[i] = Math.max(takeOne, Math.max(takeTwo, takeThree));
        }
        
        // dp[0] represents the maximum score difference Alice can achieve
        if (dp[0] > 0) {
            return "Alice";
        } else if (dp[0] < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        // Map to store value -> index pairs
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indices.put(arr[i], i);
        }
        
        // dp[i][j] represents the length of fib sequence ending with arr[i], arr[j]
        int[][] dp = new int[n][n];
        int maxLen = 0;
        
        // For each pair of numbers
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                // Current pair: arr[i], arr[j]
                // Look for arr[k] where arr[k] = arr[j] - arr[i]
                int diff = arr[j] - arr[i];
                
                // If diff exists and is less than arr[i] (to maintain increasing order)
                if (diff < arr[i] && indices.containsKey(diff)) {
                    int k = indices.get(diff);
                    // Length is previous length ending at [k,i] + 1
                    dp[i][j] = dp[k][i] + 1;
                } else {
                    // If no previous number found, length is 2
                    dp[i][j] = 2;
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        
        // Return max length if it's at least 3, otherwise 0
        return maxLen >= 3 ? maxLen : 0;
    }
}
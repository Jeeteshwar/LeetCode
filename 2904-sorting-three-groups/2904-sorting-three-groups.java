
class Solution {
    public int minimumOperations(List<Integer> nums) {
        int n = nums.size();
        if (n == 0) return 0;  // Edge case: empty list requires 0 operations
        
        // dp[i] will store the length of the longest non-decreasing subsequence ending at index i
        int[] dp = new int[n];
        int maxLen = 1;  // Initialize with minimum possible length (single element)
        Arrays.fill(dp, 1);  // Each element is a subsequence of length 1 by itself

        // Build the dp array in bottom-up manner
        for (int i = 1; i < n; i++) {
            // For each element before nums[i], check if we can extend their subsequences
            for (int j = 0; j < i; j++) {
                if (nums.get(i) >= nums.get(j)) {
                    // If current element >= previous element, we can extend the subsequence
                    // Update dp[i] if we get a longer subsequence by including nums[j]'s subsequence
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    // Keep track of the maximum subsequence length found so far
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }

        // The minimum operations needed is total elements minus the length of longest non-decreasing subsequence
        // Because we can keep this subsequence unchanged and only modify the other elements
        return n - maxLen;
    }
}
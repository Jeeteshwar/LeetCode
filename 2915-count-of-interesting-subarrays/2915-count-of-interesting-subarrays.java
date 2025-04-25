class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        long[] prefix = new long[n + 1];
        Map<Long, Long> remainderCount = new HashMap<>();
        long result = 0;
        
        // Initialize hash map with remainder 0 for empty subarray
        remainderCount.put(0L, 1L);
        
        // Compute prefix sums
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums.get(i) % modulo == k ? 1 : 0);
        }
        
        // Count interesting subarrays
        for (int i = 1; i <= n; i++) {
            long currRem = prefix[i] % modulo;
            
            // Find target remainder: (currRem - k) % modulo
            long targetRem = (currRem - k) % modulo;
            if (targetRem < 0) {
                targetRem += modulo; // Ensure non-negative remainder
            }
            
            // Add count of subarrays ending at i with remainder k
            result += remainderCount.getOrDefault(targetRem, 0L);
            
            // Update hash map with current remainder
            remainderCount.put(currRem, remainderCount.getOrDefault(currRem, 0L) + 1);
        }
        
        return result;
    }
}
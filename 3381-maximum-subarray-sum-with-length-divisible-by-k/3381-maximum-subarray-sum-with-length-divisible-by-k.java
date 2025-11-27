class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        // Map to store the minimum prefix sum for each modulus class
        HashMap<Long, Long> map = new HashMap<>();
        
        // Variable to keep track of the running prefix sum
        long pre = 0;
        
        // Variable to store the maximum subarray sum found so far
        long best = Long.MIN_VALUE;

        // Iterate through the array
        for (int j = 0; j < nums.length; j++) {
            // Calculate the modulus class for the current index
            long modIndex = j % k;

            // Update the minimum prefix sum for the current modulus class
            // This ensures we always use the smallest prefix sum for valid subarrays
            map.put(modIndex, Math.min(map.getOrDefault(modIndex, Long.MAX_VALUE), pre));
            
            // Update the running prefix sum
            pre += nums[j];
            
            // Determine the modulus class to check for forming valid subarrays
            long toCheck = (modIndex + 1) % k;
            
            // If there exists a previous prefix sum with the required modulus class,
            // calculate the subarray sum and update the best result if this sum is larger
            if (map.containsKey(toCheck)) {
                best = Math.max(best, pre - map.get(toCheck));
            }
        }

        // Return the maximum subarray sum
        return best;
    }
}

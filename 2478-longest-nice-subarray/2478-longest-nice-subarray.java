class Solution {
    public int longestNiceSubarray(int[] nums) {
         int left = 0; // Left pointer of the sliding window
        int bitmask = 0; // Bitmask to track set bits in the current window
        int Count = 0; // To store the maximum length of the nice subarray

        // Iterate through the array using the right pointer
        for (int right = 0; right < nums.length; right++) {
            // Check if the current element conflicts with the bitmask
            // (i.e., if it shares any set bits with the current window)
            while ((bitmask & nums[right]) != 0) {
                // If there is a conflict, remove the leftmost element from the bitmask
                // by performing XOR with nums[left]
                bitmask ^= nums[left];
                // Shrink the window from the left
                left++;
            }

            // Add the current element to the bitmask by performing OR with nums[right]
            bitmask |= nums[right];

            // Update the maximum length of the nice subarray
            Count = Math.max(Count, right - left + 1);
        }

        return Count; // Return the length of the longest nice subarray
    }
}
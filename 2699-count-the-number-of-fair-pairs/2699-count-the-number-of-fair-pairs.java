class Solution {
    // This helper function finds the number of pairs whose sum is less than or equal to 'targetSum'.
    private long findless(int[] nums, int targetSum) {
        int n = nums.length;   // Get the length of the array
        long pairs = 0;        // Initialize a counter for the number of pairs
        int left = 0;          // Start pointer at the beginning of the array
        int right = n - 1;     // End pointer at the last element of the array

        // Loop while the left pointer is less than the right pointer
        while (left < right) {
            // If the sum of the pair (nums[left] + nums[right]) is less than or equal to targetSum
            if (nums[left] + nums[right] <= targetSum) {
                // If it is, all pairs between 'left' and 'right' will be valid pairs
                pairs += (right - left);
                left++;   // Move the left pointer to the right to check the next possible pair
            } else {
                right--;  // If the sum is too large, move the right pointer to the left
            }
        }
        return pairs;  // Return the total number of valid pairs
    }

    // This function calculates the number of fair pairs where the sum is between 'lower' and 'upper'.
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);  // Sort the array to make the two-pointer technique work

        // Count the number of pairs whose sum is less than or equal to 'upper'
        long pairwithupper = findless(nums, upper);
        
        // Count the number of pairs whose sum is less than or equal to 'lower - 1'
        long pairwithlower = findless(nums, lower - 1);
        
        // The number of fair pairs is the difference between the two counts
        return pairwithupper - pairwithlower;
    }
}

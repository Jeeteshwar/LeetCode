class Solution {
    /**
     * Problem Statement:
     * Given an integer array `nums`, an integer `target`, and an integer `start`, 
     * find an index `i` such that `nums[i] == target` and the absolute difference 
     * `|i - start|` is minimized. Return the smallest such absolute difference.
     *
     * Example:
     * Input: nums = [1,2,3,4,5], target = 5, start = 3
     * Output: 1
     * Explanation: nums[4] = 5, and |4 - 3| = 1, which is the minimum possible.
     *
     * Approach:
     * 1. Iterate through each element in the array.
     * 2. For every element that matches the target, calculate the absolute difference 
     *    between its index and the given `start` index.
     * 3. Keep track of the minimum such absolute difference encountered.
     * 4. Return the minimum difference found.
     *
     * Time Complexity: O(n), where n is the number of elements in the array.
     * Space Complexity: O(1), as no additional space is used apart from variables.
     */
    public int getMinDistance(int[] nums, int target, int start) {
        // Initialize minIdx to the maximum possible integer value to ensure any valid 
        // difference will be smaller
        int minIdx = Integer.MAX_VALUE;
        int n = nums.length;

        // Iterate through each element in the array
        for(int i = 0 ; i < n ; i++){
            // Check if the current element matches the target
            if(nums[i] == target){
                // Calculate the absolute difference between current index and start,
                // and update minIdx if this difference is smaller
                minIdx = Math.min(minIdx, Math.abs(i - start));
            }
        }
        // Return the smallest absolute difference found
        return minIdx;
    }
}
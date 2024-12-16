class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length; // Get the size of the array

        // Perform the operation `k` times
        for (int i = 0; i < k; i++) {
            int minIdx = 0; // Initialize the index of the smallest element to 0

            // Find the index of the smallest element in the array
            for (int j = 0; j < n; j++) {
                if (nums[j] < nums[minIdx]) { // If nums[j] is smaller than the current smallest
                    minIdx = j; // Update the index of the smallest element
                }
            }

            // Multiply the smallest element by the multiplier
            nums[minIdx] *= multiplier;
        }

        // Return the modified array after `k` operations
        return nums;
    }
}

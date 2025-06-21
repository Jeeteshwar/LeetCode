class Solution {
    public boolean isMonotonic(int[] nums) {
        
        int n = nums.length;

        // Assume the array is both increasing and decreasing initially
        boolean increasing = true;
        boolean decreasing = true;

        // Loop through the array to check pairwise comparisons
        for (int i = 0; i < n - 1; i++) {
            // If a previous number is greater than the next,
            // it cannot be a strictly or non-strictly increasing array
            if (nums[i] > nums[i + 1]) {
                increasing = false;
            }
            // If a previous number is less than the next,
            // it cannot be a strictly or non-strictly decreasing array
            if (nums[i] < nums[i + 1]) {
                decreasing = false;
            }
        }

        // If the array is either entirely non-decreasing or non-increasing, it's monotonic
        return increasing || decreasing;
    }
}

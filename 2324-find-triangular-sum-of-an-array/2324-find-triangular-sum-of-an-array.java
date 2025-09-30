class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        
        // Keep reducing the array until only one element remains
        while (n > 1) {
            // Create a new array for the next level
            for (int i = 0; i < n - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            n--; // Reduce the effective size of the array
        }
        
        return nums[0];
    }
}
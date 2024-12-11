class Solution {
    public int maximumBeauty(int[] nums, int k) {
        // Sort the array to allow using a sliding window approach
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;

        int j = 0; // Initialize the right pointer of the sliding window
        for(int i = 0; i < n; i++) { // Iterate through the array with the left pointer
            // Expand the right pointer while the difference is within the allowed range
            while(j < n && (nums[j] - nums[i]) <= k * 2) {
                j++;
            }
            // Update the maximum size of the valid window
            ans = Math.max(ans, j - i);
        }
        return ans; // Return the maximum beauty (largest valid subset size)
    }
}

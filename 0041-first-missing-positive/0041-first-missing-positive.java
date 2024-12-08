class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] isThere = new boolean[n + 1]; // Changed "new int" to "new boolean"
        
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0 && nums[i] <= n) { // Ensure index stays within bounds
                isThere[nums[i]] = true;
            }
        }
        
        for (int i = 1; i <= n; i++) { // Start from 1 to find the first missing positive
            if (isThere[i] == false) {
                return i; // Return the first missing positive number
            }
        }
        
        return n + 1; // If all numbers from 1 to n are present, return n + 1 eg : n = 5 {1 2 3 4 5} res = n+1 == 6
    }
}

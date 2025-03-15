class Solution {
    public boolean canMakeArithmeticProgression(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n <= 2) return true;  // Arrays of length 1 or 2 are always arithmetic
        
        int diff = nums[1] - nums[0];  // Get the first difference
        
        // Check if all consecutive differences equal the first difference
        for(int i = 2; i < n; i++) {
            if(nums[i] - nums[i-1] != diff) {
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i <= n - 3; i++) {
            if (nums[i] == 0) {
                // Flip the triplet starting at index i
                nums[i] ^= 1; // using the xor magic to flip the numbers as it will be better than the normal if else 
                nums[i + 1] ^= 1; // i + 1 
                nums[i + 2] ^= 1; // i + 2
                count++;
            }
        }
        if(nums[n-2] == 0 || nums[n-1] == 0){
            return -1;
        }
        return count;
            }
}
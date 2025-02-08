class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int runnSum = 0;
        
        for(int i = 0 ; i < n ; i++){
            runnSum+=nums[i];
            nums[i] = runnSum;
        }
         return nums;
    }
}
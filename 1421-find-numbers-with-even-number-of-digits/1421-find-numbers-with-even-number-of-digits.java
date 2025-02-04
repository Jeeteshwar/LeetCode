class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        int n = nums.length;

        for(int i = 0 ; i < n ; i++){
            if(nums[i] > 9 && nums[i] <= 99 || nums[i] > 999 && nums[i] <= 9999 || nums[i] == 100000){

                count++;
               
            }
        }
        return count;
    }
}
class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int res = 0;
        int sum = nums[0]; // first element will always be the largest

        for(int i = 1 ; i < n ; i++){
            if(nums[i] > nums[i-1]){
                sum+=nums[i];
               
            }
            else{
                 res=Math.max(res,sum);
                 sum = nums[i]; // after break of streak the current ith value will be largest among all (by condition)
            }
        }
        return Math.max(sum,res); // because after a break of streak the sum will have more value than res 
                                    //because the array ended in increase order
    }
}
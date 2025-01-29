class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int currCount = 0;
        int count = 0;

        for(int i = 0 ; i < n ; i++){
            if(nums[i] == 1){
                currCount++;
            }
            count = Math.max(currCount,count);
            if(nums[i] != 1 ) currCount = 0;
            
        }
        return count;
    }
}
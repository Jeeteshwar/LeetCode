class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int currLen = 1; // maintain currLen     
        int maxLen = 1;  // final ans if non then always one 
        for(int i = 1 ; i < n ; i++){
            if(nums[i] > nums[i-1]){ // if curr if greater then previous ele
                currLen++; // increase the curr count
            }
            else{
                currLen = 1; // if the curr is not larger then previous then the chain will be broken so simply it won't count
            }
            maxLen = Math.max(currLen,maxLen); // if all passed then assigning the max  count to the maxLen to find next 
        }
        return maxLen;
        
    }
}
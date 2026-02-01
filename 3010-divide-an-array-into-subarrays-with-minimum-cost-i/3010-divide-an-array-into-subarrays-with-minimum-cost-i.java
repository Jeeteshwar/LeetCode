class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        int first = nums[0];
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int i = 1 ; i < n ; i++){
            if(nums[i] < min1){ // if curr is smaller than min1
                min2 = min1;
                min1 = nums[i];
            }
            else if(nums[i] < min2){ // if curr is greater than min1 but is  smaller than min2 
                min2 = nums[i];
            }
        }
        // at last send the total sum of all three smallest int
        return first + min1 + min2;
    }
}
class Solution {
    public void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] =  temp;

    }

    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        while(i < j){
            //even satisfied
            if(nums[i] % 2 == 0){
                i++;
            } 
            // odd satisfied
            else if(nums[j] % 2 != 0){
                j--;
            }
            // swap krna ha
            else{
                swap(nums, j, i);
                
            }
        }
        return nums;
    }
}
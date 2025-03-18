class Solution {
    public int countOperations(int num1, int num2) {
        int count = 0;
        int [] nums = {num1 , num2};
        Arrays.sort(nums);
            while (nums[0] != 0 && nums[1] != 0){
                if(nums[0] > nums[1]){
                    nums[0] -= nums[1];
                    count++;
                }
                else{
                    nums[1] -= nums[0];
                    count++;
                }
            }
         return count;
    }
}
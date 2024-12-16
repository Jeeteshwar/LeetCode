class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;

        for(int i = 0 ; i < k ; i++){
            int minIdx = 0;

            for(int j = 0 ; j < n ; j++){
                if(nums[j] < nums[minIdx]){
                    minIdx = j;
                }

            }
            nums[minIdx] *= multiplier;
        }
        return nums;
    }
}
class Solution {
    public int findNonMinOrMax(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if(n <= 2 ) return -1;
        
        for(int i = 0 ; i < n ; i++){
            if(nums[i] != 0){
                return nums[i + 1];
            }
        }
        return -1;
    }
}
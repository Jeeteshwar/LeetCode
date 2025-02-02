class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int peak = 0;
        for(int i = 0 ; i < n - 1; i++){
            if(nums[i] > nums[i + 1]) peak++;   // can use the no explicitly part like : nums[i] > nums[(i+1)%n]) to check nums[n-1] with nums[0]
        }
        if(nums[n-1] > nums[0]) peak++;
        return peak == 1 || peak == 0 ? true : false;
    }
}
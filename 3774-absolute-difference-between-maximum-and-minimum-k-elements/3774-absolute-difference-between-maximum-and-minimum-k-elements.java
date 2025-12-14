class Solution {
    public int absDifference(int[] nums, int k) {
        int n = nums.length;
        if (nums.length == 1) return 0;
        int res = 0;
        Arrays.sort(nums);
        int addS = 0;
        int addL = 0;
        //smallest
        for(int i = 0 ; i < k ; i++){
            addS += nums[i];
        }
        //largest
        for(int i = n - k ; i < n ; i++ ){
            addL += nums[i];
        }
        res = Math.abs(addS - addL);
        return res;
    }
}
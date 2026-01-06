class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int res = 0;
        int curr = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                curr++;
                res = Math.max(curr,res);
            } else {
                curr = 0;
            }
        }
        
        return res;
    }
}
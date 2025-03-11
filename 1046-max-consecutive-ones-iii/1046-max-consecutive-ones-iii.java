class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int left = 0;
        int subarray = 0;

        for(int right = 0 ; right < n ; right++){
            subarray += nums[right];
            while(subarray + k <  right - left +  1){
                subarray -= nums[left];
                left++;
            }
            ans = Math.max(ans , right - left +  1);
        }
        return ans;
    }
}
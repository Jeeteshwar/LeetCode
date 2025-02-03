class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int res = 1;   // Stores the longest monotonic subarray length
        int inc = 1;   // Length of increasing subarray
        int dec = 1;   // Length of decreasing subarray

        for(int i = 1 ; i < n ; i++){
            if(nums[i] > nums[i-1]){  // Increasing sequence
                inc++;
                dec = 1;   // Reset decreasing count
                res = Math.max(res, inc);
            }
            else if (nums[i-1] > nums[i]){  // Decreasing sequence
                dec++;
                inc = 1;   // Reset increasing count
                res = Math.max(res, dec);
            }
            else{  // Equal elements break monotonicity
                inc = 1;
                dec = 1;
            }
        }
        return res;
    }
}

class Solution {
    public int minCapability(int[] nums, int k) {
        int left = 0;
        int right = 0;
        
        // Find the maximum value in nums as the upper bound
        for (int num : nums) {
            right = Math.max(right, num);
        }
        
        // Binary search on the capability value
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            int i = 0;
            
            // Count how many houses we can rob with current capability
            while (i < nums.length) {
                if (nums[i] <= mid) {
                    count++;
                    i += 2; // Skip the next house
                } else {
                    i++;
                }
            }
            
            // If we can rob k or more houses, try a lower capability
            // Otherwise, we need a higher capability
            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}
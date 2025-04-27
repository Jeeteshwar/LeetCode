class Solution {
    public int countSubarrays(int[] nums) {
        int count = 0;
        // Iterate over the array to form subarrays of length 3
        for (int i = 0; i < nums.length - 2; i++) {
            // Extract the elements of the subarray
            int first = nums[i];
            int second = nums[i + 1];
            int third = nums[i + 2];
            
            // Check the condition: first + third == second / 2
            if (first + third == second / 2.0) {
                count++;
            }
        }
        return count;
    }
    }

class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;        // Get the length of the input array
        int maxValue = 0;           // This will hold the maximum value in the array
        int result = 0;             // Variable to store the length of the longest subarray with max value
        int streak = 0;             // Streak to count consecutive occurrences of the maximum value
    
        // Iterate through each element in the array
        for (int num : nums) {
            
            // If a new maximum value is found, reset result and streak
            if (num > maxValue) {
                maxValue = num;      // Update the maximum value
                result = 0;          // Reset result because we are starting a new streak with a higher max value
                streak = 0;          // Reset streak for the same reason
            }
            
            // If the current number equals the max value, increment streak
            if (maxValue == num) {
                streak++;            // Increase the length of the subarray of streak
            } else {
                streak = 0;          // If not equal to max value, reset streak
            }
            
            // Update result to store the maximum between current result and streak (if streak was useful)
            result = Math.max(result, streak);
        }
        
        return result;               // Return the length of the longest subarray of max values
    }
}

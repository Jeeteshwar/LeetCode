import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        // Sort the array to bring all elements closer in value
        Arrays.sort(nums);

        int n = nums.length;  // Get the length of the array
        int result = 0;       // Initialize result to store the maximum frequency
        long currSum = 0;     // Initialize currSum to store the sum of the current window

        int l = 0; // Left pointer to define the start of the window

        // Iterate through the array with the right pointer
        for(int r = 0 ; r < n ; r++){
            long target = nums[r]; // The current element we want to match the rest of the window to
            currSum += nums[r];    // Add the current element to the window sum
            
            // If the total operations required to make all elements in the window equal to nums[r]
            // exceeds k, then shrink the window from the left
            if((r - l + 1) * target - currSum > k){
                currSum -= nums[l]; // Remove the element at the left pointer from the window sum
                l++;                // Move the left pointer to the right to shrink the window
            }
            // Update the result to store the maximum window size
            result = Math.max(result , r - l + 1);
        }
        return result; // Return the maximum frequency found
    }
}

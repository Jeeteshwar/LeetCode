class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        // Initialize three pointers:
        // i - tracks the boundary of 0s (all elements before i are 0)
        // j - current element being processed
        // k - tracks the boundary of 2s (all elements after k are 2)
        int i = 0;
        int j = 0;
        int k = n - 1;

        // Process all elements until j crosses k
        while(j <= k) {
            if(nums[j] == 1) {
                // Case 1: Current element is 1
                // Just move j forward since 1s belong in the middle
                j++;
            }
            else if(nums[j] == 2) {
                // Case 2: Current element is 2
                // Swap with element at k to move 2 to the end
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
                
                // Decrement k since we've placed a 2 at the end
                // Don't increment j because we need to check the new element swapped from k
                k--;
            }
            else if(nums[j] == 0) {
                // Case 3: Current element is 0
                // Swap with element at i to move 0 to the beginning
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                
                // Increment both i and j since:
                // - We've placed a 0 at position i (so i moves forward)
                // - The element at j now is 1 (from i) or we've already processed it
                i++;
                j++;
            }
        }
    }
}
class Solution {
    public int singleNonDuplicate(int[] nums) {
        // Get the length of the array
        int n = nums.length;
        
        // Initialize two pointers, one at the start (left) and one at the end (right) of the array
        int left = 0;
        int right = n - 1;

        // Use binary search while the range is valid
        while (left < right) {
            // Calculate the middle index of the current range
            int mid = left + (right - left) / 2;

            // Ensure 'mid' points to the first element of a pair by making it even
            if (mid % 2 == 1) 
                mid--;  // If mid is odd, reduce it by 1 to make it even

            // Check if the element at 'mid' is equal to the one right after it (i.e., nums[mid + 1])
            if (nums[mid] == nums[mid + 1]) {
                // If they are the same, it means the single element is further on the right side
                left = mid + 2;  // Move the left pointer past this pair
            } else {
                // If they are not the same, the single element must be on the left side or at 'mid'
                right = mid;  // Narrow down the search to the left side
            }
        }
        
        // Once left == right, we've found the single element, return it
        return nums[left];
    }
}

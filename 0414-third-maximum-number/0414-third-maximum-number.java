class Solution {

    // Helper method to reverse the array
    private void reverse(int[] num) {
        int i = 0;  // Start pointer
        int j = num.length - 1;  // End pointer
        // Swap elements from the start and end until the pointers meet
        while (i < j) {
            int temp = num[i];  // Temporarily store the element at i
            num[i] = num[j];  // Assign the element at j to the position at i
            num[j] = temp;  // Assign the temporarily stored element to position j
            i++;  // Move the start pointer forward
            j--;  // Move the end pointer backward
        }
    }

    // Method to find the third maximum number in an array
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);  // Sort the array in ascending order
        reverse(nums);  // Reverse the sorted array to get descending order
        int n = nums.length;  // Length of the array
        int count = 1;  // Count to track the distinct maximum elements found
        int currentMax = nums[0];  // Initialize the first maximum as the first element

        // Iterate over the array starting from the second element
        for (int i = 1; i < n; i++) {
            // Check if the current element is different from the previous max
            if (nums[i] != currentMax) {
                currentMax = nums[i];  // Update the current max to the new element
                count++;  // Increment the count of distinct maximums found
                // If the count reaches 3, return the third maximum
                if (count == 3) {
                    return currentMax;
                }
            }
        }

        // If there are fewer than three distinct elements, return the maximum element
        return nums[0];
    }
}

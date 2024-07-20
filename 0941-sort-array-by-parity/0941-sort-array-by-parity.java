class Solution {
    // Helper method to swap elements at indices i and j in the array nums
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Method to sort array such that all even elements precede all odd elements
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length; // Get the length of the array

        int i = 0; // Initialize pointer i to start of the array
        int j = n - 1; // Initialize pointer j to end of the array

        // Loop until the two pointers meet
        while (i < j) {
            // If the element at i is even, move the i pointer to the right
            if (nums[i] % 2 == 0)
                i++;
            // If the element at j is odd, move the j pointer to the left
            else if (nums[j] % 2 != 0) 
                j--;
            // If nums[i] is odd and nums[j] is even, swap them
             else {
                swap(nums, i, j);
                i++;
                j--;
            }
            
        }
        return nums; // Return the sorted array
    }
}

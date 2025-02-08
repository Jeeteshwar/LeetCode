class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length; // Length of the array
        int i = 0; // Pointer for even indices
        int j = 1; // Pointer for odd indices

        // Loop until both pointers are within the array bounds
        while (i < n && j < n) {
            // Case 1: If nums[i] is already even, move i to the next even index
            if (nums[i] % 2 == 0) { 
                i += 2; 
            }

            // Case 2: If nums[j] is already odd, move j to the next odd index
            else if (nums[j] % 2 != 0) {
                j += 2; 
            }

            // Case 3: If nums[i] is odd and nums[j] is even, swap them
            else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i+=2;
                j+=2;
            }
        }
        return nums; // Return the rearranged array
    }
}
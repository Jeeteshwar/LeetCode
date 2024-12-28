class Solution {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) return 0; // If there's only one element, it is trivially the dominant index.
        
        int largest = 0, secondLargest = 0, idx = 0;

        // Identify the largest and second-largest numbers in the array.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                secondLargest = largest; // Update second largest.
                largest = nums[i];       // Update largest.
                idx = i;                 // Update index of largest.
            } else if (nums[i] > secondLargest) {
                secondLargest = nums[i]; // Update second largest if larger than current second largest.
            }
        }

        // Check if the largest number is at least twice as large as the second largest.
        return largest >= 2 * secondLargest ? idx : -1;
    }
}

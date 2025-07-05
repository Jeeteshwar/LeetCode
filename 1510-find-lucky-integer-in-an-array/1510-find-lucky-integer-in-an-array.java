class Solution {
    public int findLucky(int[] arr) {
        int n = arr.length;  // Store the size of the input array (not strictly necessary in this problem)

        // Step 1: Create a frequency array to count how many times each number appears in 'arr'
        // The problem says arr[i] is in the range [1, 500], so we make an array of size 501
        int[] Total = new int[501];  // Index 0 will be unused

        // Step 2: Fill the frequency array
        // For each number in the input array, increase its count at the corresponding index
        for (int num : arr) {
            Total[num]++;
        }

        // Step 3: Find the largest "lucky" number
        // A lucky number is a number whose value is equal to its frequency
        // We loop from 500 down to 1 to get the largest lucky number first
        for (int i = 500; i > 0; i--) {
            // If the number 'i' appears exactly 'i' times, it is a lucky number
            if (i == Total[i]) {
                return i;  // Return immediately once we find the largest such number
            }
        }

        // Step 4: If no lucky number is found, return -1
        return -1;
    }
}

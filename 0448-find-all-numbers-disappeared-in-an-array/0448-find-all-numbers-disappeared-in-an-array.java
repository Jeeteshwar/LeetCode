class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // Step 1: Initialize variables
        int n = nums.length; // Length of the input array
        boolean[] isThere = new boolean[n]; // Array to track presence of numbers (index-based)

        // Step 2: Mark present numbers in the boolean array
        for (int i = 0; i < n; i++) {
            // Since numbers are in the range [1, n], map each number to its index (number - 1)
            isThere[nums[i] - 1] = true; // Mark the number as present
        }

        // Step 3: Find missing numbers by checking the boolean array
        List<Integer> result = new ArrayList<>(); // List to store missing numbers
        for (int i = 0; i < n; i++) {
            if (isThere[i] == false) { // If the number corresponding to index (i + 1) is missing
                result.add(i + 1); // Add the missing number (i + 1) to the result list
            }
        }

        // Step 4: Return the result list containing all missing numbers
        return result;
    }
}

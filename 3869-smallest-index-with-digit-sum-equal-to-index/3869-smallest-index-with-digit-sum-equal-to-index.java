class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            int num = nums[i]; // Use a temporary variable to avoid modifying nums[i]

            if (num < 10) {
                if (i == num) {
                    return i; // Return the index, not the value
                }
            } else {
                while (num > 0) {
                    int digit = num % 10;
                    sum += digit;
                    num /= 10;
                }
                if (sum == i) {
                    return i; // Return the index, not the value
                }
            }
        }
        return -1; // If no index satisfies the condition
    }
}
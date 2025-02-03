class Solution {
    private static final int M = 1000000007; // 10^9 + 7

    public int numOfSubarrays(int[] arr) {
        int prefixSum = 0; // Stores sum of elements so far
        int odd = 0; // Counts prefix sums that are odd
        int even = 1; // Counts prefix sums that are even (includes empty sum)
        int res = 0; // Stores the total count of valid subarrays

        for (int num : arr) {
            prefixSum = (prefixSum + num) % M; // Update prefix sum

            if (prefixSum % 2 == 1) { // If prefix sum is odd
                res = (res + even) % M; // Add count of even prefix sums
                odd++; // Increase odd prefix count
            } else { // If prefix sum is even
                res = (res + odd) % M; // Add count of odd prefix sums
                even++; // Increase even prefix count
            }
        }

        return res;
    }
}
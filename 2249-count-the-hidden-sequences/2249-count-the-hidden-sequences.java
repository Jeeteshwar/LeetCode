class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int currentValue = 0; // Simulates building the array starting from a[0] = 0
        int minPrefixSum = 0;
        int maxPrefixSum = 0;

        for (int diff : differences) {
            currentValue += diff;
            minPrefixSum = Math.min(minPrefixSum, currentValue);
            maxPrefixSum = Math.max(maxPrefixSum, currentValue);

            if ((upper - maxPrefixSum) - (lower - minPrefixSum) + 1 <= 0) {
                return 0;
            }
        }

        return (upper - maxPrefixSum) - (lower - minPrefixSum) + 1;
    }
}

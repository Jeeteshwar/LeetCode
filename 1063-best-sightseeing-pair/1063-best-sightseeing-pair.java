class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxScore = 0;
    int maxPrefix = values[0];  // Initialize with the first spot's value plus its index

    for (int i = 1; i < values.length; i++) {
        maxScore = Math.max(maxScore, maxPrefix + values[i] - i);
        maxPrefix = Math.max(maxPrefix, values[i] + i);
    }

    return maxScore;
}
    }

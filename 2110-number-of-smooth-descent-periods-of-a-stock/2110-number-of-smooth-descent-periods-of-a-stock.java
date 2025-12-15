class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long allCount = 0;
        int currCount = 1;  // Start with 1 because a single day is a descent period of length 1.

        for (int i = 1; i < n; i++) {
            if (prices[i - 1] - prices[i] == 1) {
                // We're continuing a descent.
                currCount++;
            } else {
                // Descent broke, reset current count to 1 for the new single-day period.
                currCount = 1;
            }
            // Add the current streak length to the total count.
            allCount += currCount;
        }
        
        return allCount + 1 ;
    }
}

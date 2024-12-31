class Solution {
    public int mincostTickets(int[] days, int[] costs) {
     int n = days.length;
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int j = findIndex(days, days[i] - 7);
            int k = findIndex(days, days[i] - 30);

            dp[i + 1] = Math.min(
                dp[i] + costs[0],
                Math.min(
                    dp[j] + costs[1],
                    dp[k] + costs[2]
                )
            );
        }

        return dp[n];
    }

    private int findIndex(int[] days, int target) {
        // Binary search to find the first day greater than target
        int left = 0, right = days.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (days[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
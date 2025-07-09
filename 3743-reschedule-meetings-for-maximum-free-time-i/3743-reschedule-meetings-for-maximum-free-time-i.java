class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] durationPrefixSum = new int[n + 1];
        int maxFreeTime = 0;

        for (int i = 0; i < n; i++) {
            durationPrefixSum[i + 1] = durationPrefixSum[i] + endTime[i] - startTime[i];
        }

        for (int right = k - 1; right < n; right++) {
            int left = right - k + 1;

            int totalDuration = durationPrefixSum[right + 1] - durationPrefixSum[left];
            int intervalEnd = (right == n - 1) ? eventTime : startTime[right + 1];
            int intervalStart = (left == 0) ? 0 : endTime[left - 1];

            int freeDuration = intervalEnd - intervalStart - totalDuration;
            maxFreeTime = Math.max(maxFreeTime, freeDuration);
        }

        return maxFreeTime;
    }
}

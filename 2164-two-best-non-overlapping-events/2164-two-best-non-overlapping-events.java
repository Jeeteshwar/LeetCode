import java.util.*;

class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;

        // Step 1: Sort the events by their start time
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Build the suffix array for the maximum event value from each event onward
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = events[n - 1][2]; // Last event's value

        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(events[i][2], suffixMax[i + 1]);
        }

        // Step 3: Calculate the maximum sum of values from two non-overlapping events
        int maxSum = 0;

        for (int i = 0; i < n; i++) {
            int left = i + 1, right = n - 1;
            int nextEventIndex = -1;

            // Binary search to find the next non-overlapping event
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (events[mid][0] > events[i][1]) {
                    nextEventIndex = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // Update maxSum if a valid next event exists
            if (nextEventIndex != -1) {
                maxSum = Math.max(maxSum, events[i][2] + suffixMax[nextEventIndex]);
            }

            // Consider the case where only the current event is taken
            maxSum = Math.max(maxSum, events[i][2]);
        }

        return maxSum;
    }
}

import java.util.*;

class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int totalQueries = queries.length;
        int[] prefixDiff = new int[n + 1]; // Used as a difference array for workload tracking

        // Sort queries by starting index
        Arrays.sort(queries, Comparator.comparingInt(q -> q[0]));

        PriorityQueue<Integer> activeQueryEnds = new PriorityQueue<>(Collections.reverseOrder());
        int queryPointer = 0;

        for (int index = 0; index < n; index++) {
            if (index > 0) {
                prefixDiff[index] += prefixDiff[index - 1];
            }

            // Add all queries that start at the current index
            while (queryPointer < totalQueries && queries[queryPointer][0] == index) {
                activeQueryEnds.offer(queries[queryPointer][1]);
                queryPointer++;
            }

            // Ensure enough queries are available to reduce nums[index] to 0
            while (prefixDiff[index] < nums[index]) {
                if (activeQueryEnds.isEmpty() || activeQueryEnds.peek() < index) {
                    return -1; // Not enough valid queries to cover this index
                }

                prefixDiff[index]++;
                prefixDiff[activeQueryEnds.poll() + 1]--;
            }
        }

        return activeQueryEnds.size(); // These are the removable queries left unused
    }
}

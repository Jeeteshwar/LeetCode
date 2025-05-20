class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] coverage = new int[n + 1]; // one extra for prefix trick

        // Mark coverage ranges using prefix sum idea
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            coverage[l]++;
            if (r + 1 < n) {
                coverage[r + 1]--;
            }
        }

        // Accumulate prefix sums to get actual coverage count per index
        for (int i = 1; i < n; i++) {
            coverage[i] += coverage[i - 1];
        }

        // Check if each element can be reduced to 0
        for (int i = 0; i < n; i++) {
            if (coverage[i] < nums[i]) {
                return false;
            }
        }

        return true;
    }
}

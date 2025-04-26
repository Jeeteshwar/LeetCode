class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long totalCount = 0;
        int leftBoundary = -1, lastMinIndex = -1, lastMaxIndex = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= minK && nums[i] <= maxK) {
                lastMinIndex = (nums[i] == minK) ? i : lastMinIndex;
                lastMaxIndex = (nums[i] == maxK) ? i : lastMaxIndex;
                totalCount += Math.max(0, Math.min(lastMinIndex, lastMaxIndex) - leftBoundary);
            } else {
                leftBoundary = i;
                lastMinIndex = -1;
                lastMaxIndex = -1;
            }
        }
        return totalCount;
    }
}

class Solution {
    private int[][] memo = new int[20001][4];

    private int findMaxSum(int[] windowSums, int k, int index, int remaining) {
        if (remaining == 0) return 0;
        if (index >= windowSums.length) return Integer.MIN_VALUE;

        if (memo[index][remaining] != -1) {
            return memo[index][remaining];
        }

        int include = windowSums[index] + findMaxSum(windowSums, k, index + k, remaining - 1);
        int exclude = findMaxSum(windowSums, k, index + 1, remaining);

        memo[index][remaining] = Math.max(include, exclude);
        return memo[index][remaining];
    }

    private void collectIndices(int[] windowSums, int k, int index, int remaining, List<Integer> result) {
        if (remaining == 0 || index >= windowSums.length) return;

        int include = windowSums[index] + findMaxSum(windowSums, k, index + k, remaining - 1);
        int exclude = findMaxSum(windowSums, k, index + 1, remaining);

        if (include >= exclude) {
            result.add(index);
            collectIndices(windowSums, k, index + k, remaining - 1, result);
        } else {
            collectIndices(windowSums, k, index + 1, remaining, result);
        }
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // Initialize memoization array with -1
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int n = nums.length - k + 1;
        int[] windowSums = new int[n];
        int currentWindowSum = 0;

        // Compute sums of all k-length windows
        for (int i = 0, j = 0; j < nums.length; j++) {
            currentWindowSum += nums[j];
            if (j - i + 1 == k) {
                windowSums[i] = currentWindowSum;
                currentWindowSum -= nums[i++];
            }
        }

        List<Integer> result = new ArrayList<>();
        collectIndices(windowSums, k, 0, 3, result);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

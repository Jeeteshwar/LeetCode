import java.util.*;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];  // value
            arr[i][1] = i;        // original index
        }

        // Sort by value descending
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);

        // Take top k elements
        int[][] topK = Arrays.copyOfRange(arr, 0, k);

        // Sort top k by original index to maintain order
        Arrays.sort(topK, Comparator.comparingInt(a -> a[1]));

        // Extract result
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = topK[i][0];
        }

        return res;
    }
}

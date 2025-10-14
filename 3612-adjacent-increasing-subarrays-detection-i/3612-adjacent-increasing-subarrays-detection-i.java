import java.util.List;

class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        boolean[] inc = new boolean[n];
        
        // Precompute inc[i] - whether subarray starting at i of length k is strictly increasing
        for (int i = 0; i <= n - k; i++) {
            boolean valid = true;
            for (int j = i + 1; j < i + k; j++) {
                if (nums.get(j) <= nums.get(j - 1)) {
                    valid = false;
                    break;
                }
            }
            inc[i] = valid;
        }
        
        // Check for two adjacent increasing subarrays
        for (int a = 0; a <= n - 2 * k; a++) {
            if (inc[a] && inc[a + k]) {
                return true;
            }
        }
        
        return false;
    }
}
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        
        // Step 1: Find the longest non-decreasing prefix
        int leftt = 0;
        while (leftt + 1 < n && arr[leftt] <= arr[leftt + 1]) {
            leftt++;
        }
        
        // If the entire array is already sorted
        if (leftt == n - 1) return 0;
        
        // Step 2: Find the longest non-decreasing suffix
        int rightt = n - 1;
        while (rightt > 0 && arr[rightt - 1] <= arr[rightt]) {
            rightt--;
        }
        
        // Step 3: Find the minimum length to remove by comparing prefix and suffix
        int result = Math.min(n - leftt - 1, rightt);
        
        // Step 4: Use two pointers to find the smallest middle part to remove
        int i = 0, j = rightt;
        while (i <= leftt && j < n) {
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        
        return result;
    }
}
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0;    // Tracks maximum sum ending at current position
        int minSum = 0;    // Tracks minimum sum ending at current position
        int maxSoFar = 0;  // Tracks overall maximum absolute sum
        
        for (int num : nums) {
            // Update maxSum: either add current number or start fresh
            maxSum = Math.max(maxSum + num, num);
            // Update minSum: either add current number or start fresh
            minSum = Math.min(minSum + num, num);
            // Update maxSoFar: compare with absolute values of maxSum and minSum
            maxSoFar = Math.max(maxSoFar, Math.max(Math.abs(maxSum), Math.abs(minSum)));
        }
        
        return maxSoFar;
    }
}
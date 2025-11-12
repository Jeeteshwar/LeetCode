class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        
        // Count number of 1s already present
        int onesCount = 0;
        for (int num : nums) {
            if (num == 1) {
                onesCount++;
            }
        }
        
        // If there's at least one 1, we can convert all other elements
        if (onesCount > 0) {
            return n - onesCount;
        }
        
        // Find the smallest subarray with GCD = 1
        int minLength = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            int currentGcd = nums[i];
            for (int j = i; j < n; j++) {
                currentGcd = gcd(currentGcd, nums[j]);
                if (currentGcd == 1) {
                    minLength = Math.min(minLength, j - i + 1);
                    break;
                }
            }
        }
        
        // If no subarray with GCD = 1 exists, return -1
        if (minLength == Integer.MAX_VALUE) {
            return -1;
        }
        
        // Operations = (minLength - 1) to create first 1 + (n - 1) to convert rest
        return (minLength - 1) + (n - 1);
    }
    
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
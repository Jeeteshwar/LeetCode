class Solution {
    public int minimumRecolors(String blocks, int k) {
        // Initialize the minimum operations needed as maximum possible value
        int minOperations = Integer.MAX_VALUE;
        
        // Use sliding window of size k
        for (int i = 0; i <= blocks.length() - k; i++) {
            // Count white blocks in current window that need to be recolored
            int operations = 0;
            for (int j = i; j < i + k; j++) {
                if (blocks.charAt(j) == 'W') {
                    operations++;
                }
            }
            // Update minimum operations if current is smaller
            minOperations = Math.min(minOperations, operations);
        }
        
        return minOperations;
    }
}
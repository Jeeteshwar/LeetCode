class Solution {
    public int binaryGap(int n) {
        int maxGap = 0;
        int prevOnePosition = -1;
        int currentPosition = 0;
        
        // Iterate through each bit of the number
        while (n > 0) {
            // Check if the current bit is 1
            if ((n & 1) == 1) {
                // If we've seen a 1 before, calculate the distance
                if (prevOnePosition != -1) {
                    maxGap = Math.max(maxGap, currentPosition - prevOnePosition);
                }
                // Update the previous 1's position
                prevOnePosition = currentPosition;
            }
            
            // Move to the next bit
            n >>= 1;
            currentPosition++;
        }
        
        return maxGap;
    }
}
public class Solution {
    public boolean hasAlternatingBits(int n) {
        // Get the last bit of n
        int lastBit = n & 1;
        n >>= 1; // Right-shift n by 1 to remove the last bit

        while (n > 0) {
            // Get the current last bit
            int currentBit = n & 1;
            // If the current bit is the same as the last bit, return false
            if (currentBit == lastBit) {
                return false;
            }
            // Update the last bit
            lastBit = currentBit;
            // Shift n to the right by 1
            n >>= 1;
        }

        // If we exit the loop, all bits are alternating
        return true;
    }
}
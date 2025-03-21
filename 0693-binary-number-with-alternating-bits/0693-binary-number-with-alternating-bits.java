public class Solution {
    public boolean hasAlternatingBits(int n) {
        // Step 1: Extract the last bit of n
        // For n = 5 (binary: 101), n & 1 gives 1 (last bit)
        int lastBit = n & 1;
        // Right-shift n by 1 to remove the last bit
        // n becomes 101 >> 1 = 010 (binary), which is 2 in decimal
        n >>= 1;

        // Step 2: Loop through the remaining bits
        while (n > 0) {
            // Extract the current last bit
            // For n = 2 (binary: 10), n & 1 gives 0 (last bit)
            int currentBit = n & 1;
            // Compare the current bit with the last bit
            // If they are the same, the bits are not alternating
            // For n = 2, lastBit = 1 and currentBit = 0 → they are different
            if (currentBit == lastBit) {
                return false;
            }
            // Update the last bit to the current bit
            // lastBit becomes 0
            lastBit = currentBit;
            // Right-shift n by 1 to process the next bit
            // n becomes 10 >> 1 = 01 (binary), which is 1 in decimal
            n >>= 1;
        }

        // Step 3: If the loop completes, all bits are alternating
        // For n = 5, the loop processes all bits without finding adjacent duplicates
        return true;
    }
}
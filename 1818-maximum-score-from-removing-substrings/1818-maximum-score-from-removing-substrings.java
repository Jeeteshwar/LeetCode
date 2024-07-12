class Solution {
    public int maximumGain(String s, int x, int y) {
        // Length of the string
        int n = s.length();
        // Counters for 'a' and 'b' characters
        int aCount = 0;
        int bCount = 0;
        // Result to store the maximum gain
        int result = 0;
        // Lesser value between x and y, used for calculating remaining pairs
        int lesser = Math.min(x, y);

        // Iterate through each character in the string
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // If the character is not 'a' or 'b', calculate the gain from existing 'a' and 'b' counts
            if (c > 'b') {
                result += Math.min(aCount, bCount) * lesser;
                // Reset the counters for 'a' and 'b'
                aCount = 0;
                bCount = 0;
            } else if (c == 'a') {
                // If 'y' is greater and there are 'b's to form "ba" pairs
                if (x < y && bCount > 0) {
                    bCount--;
                    result += y; // Add the gain for "ba"
                } else {
                    aCount++; // Otherwise, count the 'a'
                }
            } else if (c == 'b') {
                // If 'x' is greater and there are 'a's to form "ab" pairs
                if (x > y && aCount > 0) {
                    aCount--;
                    result += x; // Add the gain for "ab"
                } else {
                    bCount++; // Otherwise, count the 'b'
                }
            }
        }

        // Add the remaining gain from leftover 'a' and 'b' pairs
        result += Math.min(aCount, bCount) * lesser;
        return result;
    }
}

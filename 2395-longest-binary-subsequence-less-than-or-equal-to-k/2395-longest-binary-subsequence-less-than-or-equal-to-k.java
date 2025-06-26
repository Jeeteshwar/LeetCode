class Solution {
    public int longestSubsequence(String s, int k) {
        int zeros = 0;
        int len = s.length();
        
        // Count all zeros (they can always be included)
        for (char c : s.toCharArray()) {
            if (c == '0') zeros++;
        }

        int count = 0; // count of 1s we can include
        long value = 0; // to hold the value of binary number formed
        int power = 0;

        // Traverse from the end (LSB to MSB)
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                if (power < 32) { // prevent overflow
                    value += 1L << power;
                    if (value <= k) {
                        count++;
                    } else {
                        break;
                    }
                } else {
                    break; // beyond 2^31, not needed
                }
            }
            power++;
        }

        return zeros + count;
    }
}

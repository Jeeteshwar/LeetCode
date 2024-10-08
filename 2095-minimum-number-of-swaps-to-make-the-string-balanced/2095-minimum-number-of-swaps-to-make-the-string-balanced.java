class Solution {
    public int minSwaps(String s) {
        int n = s.length(); // Get the length of the string
        int count_o = 0;    // Counter to track the net number of open brackets '['
        int count_c = 0;    // Counter to track imbalances (extra closing brackets ']')
        
        // Iterate through the string
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '[') { 
                count_o++; // Increment count_o for an open bracket '['
            } else {
                count_o--; // Decrement count_o for a closing bracket ']'
            }

            // If more closing brackets have appeared than opening brackets
            if (count_o < 0) {
                count_c++;  // Increment count_c, as we have an imbalance
                count_o = 0; // Reset count_o to 0 because the imbalance is being tracked by count_c
            }
        }

        // The result is the minimum number of swaps needed to balance
        // (count_c + 1) / 2 ensures that any odd number of imbalances is rounded up
        return (count_c + 1) / 2;
    }
}

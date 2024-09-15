class Solution {
    public int findTheLongestSubstring(String s) {
        // Create a map to store the first occurrence of each unique bitmask
        Map<Integer, Integer> mp = new HashMap<>();
        
        // Initialize a mask to represent the state of vowels.
        // A 5-bit binary mask where each bit represents whether a vowel ('a', 'e', 'i', 'o', 'u') has appeared an odd number of times.
        int mask = 0;

        // Add initial state (mask = 0) at index -1, meaning no characters have been processed yet.
        mp.put(mask, -1);

        // Variable to track the maximum length of the substring found
        int maxL = 0;

        // Loop through the string one character at a time
        for (int i = 0; i < s.length(); i++) {
            int val = 0;  // Variable to store the corresponding bit for the current vowel

            // Check if the current character is a vowel and update the value of val accordingly.
            // Each vowel has a specific bit in the mask.
            if (s.charAt(i) == 'a')      val = (1 << 0);  // Bit 0 for 'a'
            else if (s.charAt(i) == 'e') val = (1 << 1);  // Bit 1 for 'e'
            else if (s.charAt(i) == 'i') val = (1 << 2);  // Bit 2 for 'i'
            else if (s.charAt(i) == 'o') val = (1 << 3);  // Bit 3 for 'o'
            else if (s.charAt(i) == 'u') val = (1 << 4);  // Bit 4 for 'u'

            // Toggle the corresponding bit in the mask using XOR
            mask ^= val;

            // If the current mask has not been seen before, store its index in the map
            if (!mp.containsKey(mask))
                mp.put(mask, i);

            // Calculate the length of the substring by finding the difference between
            // the current index and the first occurrence of the same mask.
            // This ensures that the substring has an even count of vowels.
            maxL = Math.max(maxL, i - mp.get(mask));
        }

        // Return the length of the longest substring with an even count of vowels
        return maxL;
    }
}

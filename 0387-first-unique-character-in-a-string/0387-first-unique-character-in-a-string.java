class Solution {
    public int firstUniqChar(String s) {
        // Step 1: Create an array to store the frequency of each character
        // The array has a size of 26 to represent the 26 lowercase English letters ('a' to 'z').
        int[] freq = new int[26];

        // Step 2: Count the frequency of each character in the string
        for (char c : s.toCharArray()) {
            // Calculate the index of the character in the frequency array
            // Example: 'a' - 'a' = 0, 'b' - 'a' = 1, ..., 'z' - 'a' = 25
            freq[c - 'a']++;
        }

        // Step 3: Iterate over the string to find the first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            // Check if the frequency of the current character is exactly 1
            if (freq[s.charAt(i) - 'a'] == 1) {
                // Return the index of the first non-repeating character
                return i;
            }
        }

        // Step 4: If no non-repeating character is found, return -1
        return -1;
    }
}

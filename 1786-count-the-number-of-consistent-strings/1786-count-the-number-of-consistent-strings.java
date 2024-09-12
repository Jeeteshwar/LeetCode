class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        // Step 1: Create a HashSet to store the characters from the 'allowed' string.
        HashSet<Character> seen = new HashSet<>();

        // Step 2: Loop through the 'allowed' string and add each character to the 'seen' set.
        // The HashSet helps in efficiently checking if a character is allowed later.
        for (int i = 0; i < allowed.length(); i++) {
            seen.add(allowed.charAt(i)); // Adding each allowed character to the HashSet
        }

        // Step 3: Initialize a count to store the number of consistent strings.
        int count = 0;

        // Step 4: Iterate through each word in the 'words' array.
        for (String word : words) {
            // Step 5: Initialize a flag to 1, assuming the word is consistent.
            // The 'flag' is used to track whether the current word is consistent with the allowed characters.
            // If the word contains any character not in the 'seen' HashSet, we set the flag to 0.
            int flag = 1;

            // Step 6: Iterate through each character in the current word.
            for (int i = 0; i < word.length(); i++) {
                // Step 7: Check if the current character is not in the 'seen' set of allowed characters.
                if (!seen.contains(word.charAt(i))) {
                    // Step 8: If a character is not allowed, set the flag to 0 and break the loop.
                    // This means the current word is not consistent, so we stop checking further.
                    flag = 0;
                    break;
                }
            }

            // Step 9: Add the value of the flag to the count.
            // If the flag is 1, the word is consistent, so we add 1 to the count.
            count += flag;
        }

        // Step 10: Return the total count of consistent words.
        return count;
    }
}

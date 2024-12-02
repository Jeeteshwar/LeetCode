class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ");  // Split the sentence into individual words based on spaces.
        int n = arr.length;                  // Get the total number of words in the array.

        for (int i = 0; i < n; i++) {
            // Check if the current word starts with the given searchWord.
            if (arr[i].startsWith(searchWord)) {
                return i + 1;  // Return the 1-based index if a match is found.
            }
        }
        return -1;  // Return -1 if no word starts with the searchWord.
    }
}

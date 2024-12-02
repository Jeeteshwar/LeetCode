class Solution {
    public int countPrefixes(String[] words, String s) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (s.startsWith(words[i])) { // Check if 's' starts with the word
                count++;
            }
        }
        return count;
    }
}

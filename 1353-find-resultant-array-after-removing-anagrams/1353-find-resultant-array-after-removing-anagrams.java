import java.util.*;

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        
        // Always add the first word
        result.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            // Check if current word is an anagram of the last word in result
            if (!isAnagram(result.get(result.size() - 1), words[i])) {
                result.add(words[i]);
            }
        }
        
        return result;
    }
    
    private boolean isAnagram(String word1, String word2) {
        // If lengths are different, they can't be anagrams
        if (word1.length() != word2.length()) {
            return false;
        }
        
        // Count frequency of characters
        int[] freq = new int[26];
        
        for (char c : word1.toCharArray()) {
            freq[c - 'a']++;
        }
        
        for (char c : word2.toCharArray()) {
            freq[c - 'a']--;
        }
        
        // Check if all frequencies are zero
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }
}
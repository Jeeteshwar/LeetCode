import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {
        // Store the last occurrence of each character
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        List<Integer> result = new ArrayList<>();
        int start = 0;  // Start of current partition
        int end = 0;    // End of current partition
        
        for (int i = 0; i < s.length(); i++) {
            // Update end to the maximum last occurrence of any character seen so far
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            
            // If we've reached the end of a valid partition
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        
        return result;
    }
}
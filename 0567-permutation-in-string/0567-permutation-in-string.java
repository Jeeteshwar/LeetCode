class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
      
        // If the first string is longer than the second string,
        // it's not possible for s1 to be a permutation of s2.
        if (length1 > length2) {
            return false;
        }
      
        // Array to hold the difference in character counts between s1 and s2.
        int[] charCountDelta = new int[26];
      
        // Populate the array with initial counts
        for (int i = 0; i < length1; ++i) {
            charCountDelta[s1.charAt(i) - 'a']--;
            charCountDelta[s2.charAt(i) - 'a']++;
        }
      
        // Counts the number of characters with non-zero delta counts.
        int nonZeroCount = 0;
        for (int count : charCountDelta) {
            if (count != 0) {
                nonZeroCount++;
            }
        }
      
        // If all deltas are zero, s1 is a permutation of the first part of s2.
        if (nonZeroCount == 0) {
            return true;
        }
      
        // Slide the window of length1 through s2
        for (int i = length1; i < length2; ++i) {
            int charLeft = s2.charAt(i - length1) - 'a'; // Character going out of the window
            int charRight = s2.charAt(i) - 'a'; // Character coming into the window
          
            // Update counts for the exiting character
            if (charCountDelta[charRight] == 0) {
                nonZeroCount++;
            }
            charCountDelta[charRight]++;
            if (charCountDelta[charRight] == 0) {
                nonZeroCount--;
            }
          
            // Update counts for the entering character
            if (charCountDelta[charLeft] == 0) {
                nonZeroCount++;
            }
            charCountDelta[charLeft]--;
            if (charCountDelta[charLeft] == 0) {
                nonZeroCount--;
            }
          
            // If all deltas are zero, s1's permutation is found in s2.
            if (nonZeroCount == 0) {
                return true;
            }
        }
      
        // If we reach here, no permutation of s1 is found in s2.
        return false;
    }
}
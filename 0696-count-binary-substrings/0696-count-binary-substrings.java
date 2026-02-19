class Solution {
    public int countBinarySubstrings(String s) {
        int count = 0;
        int prevGroup = 0;
        int currGroup = 1;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currGroup++;
            } else {
                // When we switch to a different character
                // Add the minimum of previous and current group to count
                count += Math.min(prevGroup, currGroup);
                prevGroup = currGroup;
                currGroup = 1;
            }
        }
        
        // Don't forget to add the last pair
        count += Math.min(prevGroup, currGroup);
        
        return count;
    }
}
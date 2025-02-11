class Solution {
    public boolean areOccurrencesEqual(String s) {
        int [] count = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }
        int firstCount = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                if (firstCount == 0) {
                    firstCount = count[i]; // Set the first non-zero count as the reference
                } if (count[i] != firstCount) {
                    return false; // If any count differs from the first count, return false
                }
            }
        }
        
        return true; // All non-zero counts are equal
    }
}
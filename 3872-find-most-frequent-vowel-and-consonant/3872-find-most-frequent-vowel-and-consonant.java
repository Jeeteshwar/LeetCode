class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        int maxVowelFreq = 0;
        int maxConsonantFreq = 0;
        
        for (int i = 0; i < 26; i++) {
            char ch = (char) (i + 'a');
            if (isVowel(ch)) {
                maxVowelFreq = Math.max(maxVowelFreq, freq[i]);
            } else {
                maxConsonantFreq = Math.max(maxConsonantFreq, freq[i]);
            }
        }
        
        return maxVowelFreq + maxConsonantFreq;
    }
    
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}

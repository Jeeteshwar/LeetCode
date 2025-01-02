class Solution {
    public int[] vowelStrings(String[] strings, int[][] ranges) {
        int stringCount = strings.length;
        int rangeCount = ranges.length;
        int[] answers = new int[rangeCount];
        int[] prefixSum = new int[stringCount];
        
        // Build prefix sum array
        int currentSum = 0;
        for (int index = 0; index < stringCount; index++) {
            if (isVowel(strings[index].charAt(0)) && isVowel(strings[index].charAt(strings[index].length() - 1))) {
                currentSum++;
            }
            prefixSum[index] = currentSum;
        }
        
        // Process each range
        for (int index = 0; index < rangeCount; index++) {
            int start = ranges[index][0];
            int end = ranges[index][1];
            answers[index] = prefixSum[end] - (start > 0 ? prefixSum[start - 1] : 0);
        }
        
        return answers;
    }
    
    // Helper function to check if a character is a vowel
    private boolean isVowel(char character) {
        return character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u';
    }
}

class Solution {
    public int countPalindromicSubsequence(String inputString) {
        int stringLength = inputString.length();
        int palindromeCount = 0;

        int[] firstOccurrence = new int[26]; // Stores the first index of each character
        int[] lastOccurrence = new int[26]; // Stores the last index of each character
        int[] charFrequency = new int[26]; // Stores the frequency of each character

        Arrays.fill(firstOccurrence, Integer.MAX_VALUE);
        Arrays.fill(lastOccurrence, Integer.MIN_VALUE);

        // Populate firstOccurrence, lastOccurrence, and charFrequency arrays
        for (int index = 0; index < stringLength; index++) {
            int charIndex = inputString.charAt(index) - 'a';
            firstOccurrence[charIndex] = Math.min(firstOccurrence[charIndex], index);
            lastOccurrence[charIndex] = Math.max(lastOccurrence[charIndex], index);
            charFrequency[charIndex]++;
        }

        // Count unique palindromic subsequences
        for (int charIndex = 0; charIndex < 26; charIndex++) {
            if (charFrequency[charIndex] == 0) continue; // Skip unused characters

            int middleCharCount = 0;
            int[] middleCharTracker = new int[26]; // Tracks characters used as middle characters

            // Count unique middle characters for the current outer character
            for (int midIndex = firstOccurrence[charIndex] + 1; midIndex < lastOccurrence[charIndex]; midIndex++) {
                int middleCharIndex = inputString.charAt(midIndex) - 'a';

                if (middleCharTracker[middleCharIndex] == 1 || charIndex == middleCharIndex) continue;
                if (middleCharCount == 25) break; // Maximum unique middle characters is 25

                middleCharTracker[middleCharIndex] = 1;
                middleCharCount++;
            }

            palindromeCount += middleCharCount;
        }

        // Add counts for characters that appear at least three times
        for (int charIndex = 0; charIndex < 26; charIndex++) {
            if (charFrequency[charIndex] >= 3) {
                palindromeCount++;
            }
        }

        return palindromeCount;
    }
}
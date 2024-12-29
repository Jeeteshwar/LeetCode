import java.util.*;

class Solution {
    public int numWays(String[] wordList, String targetString) {
        final int MODULO = 1_000_000_007;
        int columnCount = wordList[0].length(); // Number of columns
        int targetLength = targetString.length(); // Length of the target

        // Step 1: Precompute character frequencies for each column
        int[][] charFrequencyMatrix = new int[columnCount][26];
        for (String word : wordList) {
            for (int col = 0; col < columnCount; col++) {
                charFrequencyMatrix[col][word.charAt(col) - 'a']++;
            }
        }

        // Step 2: Initialize a DP array
        int[] waysToForm = new int[targetLength + 1];
        waysToForm[0] = 1; // Base case: 1 way to form an empty target

        // Step 3: Iterate through columns
        for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
            // Step 4: Update DP array in reverse to avoid overwriting
            for (int targetIndex = targetLength - 1; targetIndex >= 0; targetIndex--) {
                char currentTargetChar = targetString.charAt(targetIndex);
                int charCount = charFrequencyMatrix[columnIndex][currentTargetChar - 'a'];

                if (charCount > 0) {
                    waysToForm[targetIndex + 1] = (int) ((waysToForm[targetIndex + 1] 
                            + (long) waysToForm[targetIndex] * charCount % MODULO) % MODULO);
                }
            }
        }

        // Step 5: Return the result
        return waysToForm[targetLength];
    }
}

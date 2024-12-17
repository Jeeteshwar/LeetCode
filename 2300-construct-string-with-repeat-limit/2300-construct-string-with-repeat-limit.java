class Solution {
    public String repeatLimitedString(String inputString, int maxRepeatLimit) {
        int[] charFrequency = new int[26]; // Frequency array to store character counts

        // Count the frequency of each character
        for (char currentChar : inputString.toCharArray()) { // T.C: O(n)
            charFrequency[currentChar - 'a']++;
        }

        StringBuilder resultString = new StringBuilder();
        int currentIndex = 25; // Start from the largest character (z)

        while (currentIndex >= 0) { // T.C: O(26)
            if (charFrequency[currentIndex] == 0) {
                currentIndex--;
                continue;
            }

            char currentCharacter = (char) ('a' + currentIndex); // Convert index to character
            int appendCount = Math.min(charFrequency[currentIndex], maxRepeatLimit); // Append up to 'maxRepeatLimit' times

            for (int counter = 0; counter < appendCount; counter++) {
                resultString.append(currentCharacter);
            }
            charFrequency[currentIndex] -= appendCount;

            if (charFrequency[currentIndex] > 0) {
                // Find the next largest character
                int nextIndex = currentIndex - 1;
                while (nextIndex >= 0 && charFrequency[nextIndex] == 0) { // O(26)
                    nextIndex--;
                }

                if (nextIndex < 0) {
                    break; // No more characters left to append
                }

                resultString.append((char) ('a' + nextIndex)); // Append the next largest character once
                charFrequency[nextIndex]--;
            }
        }

        return resultString.toString();
    }
}

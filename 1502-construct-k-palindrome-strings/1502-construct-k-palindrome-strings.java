class Solution {
    public boolean canConstruct(String inputString, int numPalindromes) {
        if (inputString.length() < numPalindromes) return false;

        char[] sortedChars = inputString.toCharArray();
        Arrays.sort(sortedChars);
        int oddFrequencyCount = 0;

        for (int index = 0; index < sortedChars.length; ) {
            char currentChar = sortedChars[index];
            int charFrequency = 0;
            while (index < sortedChars.length && sortedChars[index] == currentChar) {
                charFrequency++;
                index++;
            }
            if (charFrequency % 2 != 0) oddFrequencyCount++;
        }

        return oddFrequencyCount <= numPalindromes;
    }
}

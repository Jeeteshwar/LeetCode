class Solution {
    public String shiftingLetters(String inputString, int[][] shiftOperations) {
        int length = inputString.length();
        int[] shiftArray = new int[length]; // Array to store shift differences

        // Step 1: Populate the shift array
        for (int[] operation : shiftOperations) {
            int startIndex = operation[0];
            int endIndex = operation[1];
            int direction = operation[2];

            if (direction == 1) { // Forward shift
                shiftArray[startIndex] += 1;
                if (endIndex + 1 < length) {
                    shiftArray[endIndex + 1] -= 1;
                }
            } else { // Backward shift
                shiftArray[startIndex] -= 1;
                if (endIndex + 1 < length) {
                    shiftArray[endIndex + 1] += 1;
                }
            }
        }

        // Step 2: Compute the prefix sum to get the net shifts for each character
        for (int i = 1; i < length; i++) {
            shiftArray[i] += shiftArray[i - 1]; // Add the value from the previous index
        }

        // Step 3: Apply the shifts to the string
        StringBuilder resultString = new StringBuilder(inputString);
        for (int i = 0; i < length; i++) {
            int netShift = shiftArray[i] % 26; // Ensure shift is within the range [0, 25]
            if (netShift < 0) {
                netShift += 26; // Handle negative shifts (backward)
            }

            // Apply the shift to the character
            char shiftedChar = (char) (((resultString.charAt(i) - 'a' + netShift) % 26) + 'a');
            resultString.setCharAt(i, shiftedChar);
        }

        return resultString.toString();
    }
}

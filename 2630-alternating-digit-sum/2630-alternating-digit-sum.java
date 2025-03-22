class Solution {
    public int alternateDigitSum(int n) {
        // Step 1: Convert the number to a string
        String numStr = Integer.toString(n);

        // Step 2: Initialize the sum
        int sum = 0;

        // Step 3: Iterate through each character in the string
        for (int i = 0; i < numStr.length(); i++) {
            // Step 4: Get the current digit as an integer
            int digit = Character.getNumericValue(numStr.charAt(i));

            // Step 5: Alternate the sign based on the position
            if (i % 2 == 0) {
                sum += digit; // Positive sign for even indices (0, 2, 4, ...)
            } else {
                sum -= digit; // Negative sign for odd indices (1, 3, 5, ...)
            }
        }

        // Step 6: Return the final sum
        return sum;
    }
}
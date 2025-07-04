class Solution {
    public int titleToNumber(String col) {
        int sum = 0; // This will store the final column number
        int p = 0;   // This will act like the power for 26 (like ones, tens, hundreds place in base-26)
        int n = col.length(); // Get the length of the column string

        // Loop through the string from last character to first (right to left)
        for(int i = n - 1 ; i >= 0 ; i--){
            // Convert the character to a number: 'A' becomes 1, 'B' becomes 2, ..., 'Z' becomes 26
            // Since 'A' has ASCII value 65, we subtract 64
            int temp = col.charAt(i) - 64;

            // Multiply the number with 26^p (like base-26 number system) and add to sum
            sum += Math.pow(26, p) * temp;

            // Move to the next power (left side in the string)
            p++;
        }

        // Return the final converted column number
        return sum;
    }
}

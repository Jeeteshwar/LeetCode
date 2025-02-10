class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        for (int i = 0; i < sb.length(); i++) {
            char currentChar = sb.charAt(i);
            if (Character.isDigit(currentChar)) { // Check if the character is a digit
                sb.delete(i - 1, i + 1); // Delete the digit and its preceding character
                i -= 2; // Adjust index to account for deletion
                if (i < -1) { // Ensure index doesn't go out of bounds
                    i = -1;
                }
            }
        }
        
        return sb.toString(); // Return the modified string
    }
}
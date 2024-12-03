class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder result = new StringBuilder(); // Initialize result string builder
        int m = s.length(); // Length of the input string
        int n = spaces.length; // Number of spaces to add

        int j = 0; // Pointer to track the current space index in the `spaces` array

        // Iterate over the string
        for (int i = 0; i < m; i++) {
            // Check if current index matches the space position
            if (j < n && i == spaces[j]) {
                result.append(" "); // Add a space
                j++; // Move to the next space index
            }// if not
            result.append(s.charAt(i)); // Add the current character to the result
        }
        return result.toString(); // Return the modified string with spaces
    }
}

class Solution {
    public String capitalizeTitle(String title) {
        // Split the input title into words using space as a delimiter
        String[] toStr = title.split(" ");
        String res = ""; // Initialize an empty string to build the final result

        // Iterate through each word in the split array
        for (int i = 0; i < toStr.length; i++) {
            // Convert the entire word to lowercase using the inbuilt `toLowerCase()` method
            toStr[i] = toStr[i].toLowerCase();

            // Check if the length of the word is 2 or less
            if (toStr[i].length() <= 2) {
                // Short words (length ≤ 2) remain in lowercase
                res += toStr[i] + " "; // Append the word and a trailing space to the result
                continue; // Skip the rest of the loop for this iteration
            } else {
                // Capitalize the first letter of words longer than 2 characters
                // `substring(0, 1)` extracts the first character of the string
                // `toUpperCase()` converts that character to uppercase
                // `substring(1)` extracts the rest of the string starting from index 1
                toStr[i] = toStr[i].substring(0, 1).toUpperCase() + toStr[i].substring(1);

                // Append the modified word with a trailing space to the result
                res += toStr[i] + " ";
            }
        }
        // Use the `trim()` method to remove any trailing spaces from the final string
        return res.trim();
    }
}

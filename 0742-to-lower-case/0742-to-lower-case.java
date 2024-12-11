class Solution {
    public String toLowerCase(String s) {
        StringBuilder result = new StringBuilder();
        
        // Iterate through each character in the input string
        for (char c : s.toCharArray()) {
            // If the character is an uppercase letter (A-Z)
            if (c >= 'A' && c <= 'Z') {
                // Convert it to its lowercase equivalent by adding 32
                result.append((char)(c + 32));
            } else {
                // Otherwise, append the character as is
                result.append(c);
            }
        }
        
        // Convert StringBuilder to String and return
        return result.toString();
    }
}
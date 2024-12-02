class Solution {
    public boolean isPrefixString(String s, String[] words) {
        // Create a StringBuilder to build the prefix incrementally
        StringBuilder prefix = new StringBuilder();
        
        // Loop through each word in the 'words' array
        for (String word : words) {
            // Append the current word to the prefix
            prefix.append(word);
            
            // Check if the current prefix matches the string 's'
            if (prefix.toString().equals(s)) {
                // If the prefix matches, return true
                return true;
            }
            
            // If the length of the prefix exceeds the length of 's', no valid prefix can be found
            if (prefix.length() > s.length()) {
                // If prefix is longer than 's', we can stop and return false
                return false;
            }
        }
        
        // If the loop completes and no matching prefix is found, return false
        return false;
    }
}

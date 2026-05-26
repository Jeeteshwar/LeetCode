class Solution {
    public int numberOfSpecialChars(String word) {
        // Arrays to store the frequency of lowercase ('a' to 'z') and uppercase ('A' to 'Z') letters
        int a[] = new int[26];  
        int b[] = new int[26];
        
        // Iterate through each character in the word
        for(char c : word.toCharArray()) {
            // If the character is a lowercase letter, update its frequency in array 'a'
            if(c >= 'a' && c <= 'z') {
                a[c - 'a']++;
            }
            // If the character is an uppercase letter, update its frequency in array 'b'
            else {
                b[c - 'A']++;
            }
        }
        
        int count = 0; // Counter to track "special characters"

        // Check for letters that appear in both uppercase and lowercase
        for(int i = 0; i < 26; i++) {
            // If the letter appears in both lowercase and uppercase, increment the count
            if(a[i] != 0 && b[i] != 0) {
                count++;
            }
        }
        
        return count; // Return the count of "special characters"
    }
}

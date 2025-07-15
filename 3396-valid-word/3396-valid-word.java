class Solution {
    public boolean isValid(String word) {
        
          
        if (word.length() < 3) {
            return false;
        }

        // Step 2: Check if the word contains only allowed characters
        for (char c : word.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }

        // Step 3: Check if the word contains at least one vowel
        boolean hasVowel = false;
        for (char c : word.toCharArray()) {
            if (isVowel(c)) {
                hasVowel = true;
                break;
            }
        }
        if (!hasVowel) {
            return false;
        }

        // Step 4: Check if the word contains at least one consonant
        boolean hasConsonant = false;
        for (char c : word.toCharArray()) {
            if (isConsonant(c)) {
                hasConsonant = true;
                break;
            }
        }
        if (!hasConsonant) {
            return false;
        }

        // If all conditions are met, the word is valid
        return true;
    }

    private boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') &&
               Character.isLetter(c);
    }

    private boolean isConsonant(char c) {
        return Character.isLetter(c) && !isVowel(c);
        
        
        
    }
}
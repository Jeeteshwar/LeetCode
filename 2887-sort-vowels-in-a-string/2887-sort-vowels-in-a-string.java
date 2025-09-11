import java.util.*;

class Solution {
    public String sortVowels(String s) {
        // Count frequencies of each vowel
        int[] vowelCount = new int[128]; // ASCII table size
        
        // First pass: count vowels
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowelCount[c]++;
            }
        }
        
        // Create sorted order of vowels
        String vowelOrder = "AEIOUaeiou";
        
        // Second pass: build the result
        StringBuilder result = new StringBuilder();
        int vowelIndex = 0;
        
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                // Find the next available vowel
                while (vowelIndex < vowelOrder.length() && 
                       vowelCount[vowelOrder.charAt(vowelIndex)] == 0) {
                    vowelIndex++;
                }
                
                result.append(vowelOrder.charAt(vowelIndex));
                vowelCount[vowelOrder.charAt(vowelIndex)]--;
            } else {
                result.append(c);
            }
        }
        
        return result.toString();
    }
    
    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
class Solution {
    public char repeatedCharacter(String s) {

        // Create a HashSet to keep track of characters we've seen so far
        Set<Character> seen = new HashSet<>();

        // Convert the string to a character array and iterate over it
        for(char c : s.toCharArray()){
            
            // Check if the current character is already in the HashSet
            if(seen.contains(c)){
                // If it is, this means it's the first repeated character, so return it
                return c;
            }
            
            // If the character is not in the HashSet, add it to the set
            seen.add(c);
        }
        
        // If no repeated character is found, return null character (this case assumes input always has a repeated character)
        return '\0';
    }
}

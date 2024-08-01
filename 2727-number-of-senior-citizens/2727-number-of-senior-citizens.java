class Solution {
    public int countSeniors(String[] details) {
        int seniorCount = 0; // Initialize counter for senior citizens
        
        // Iterate through each detail string in the array
        for(String info : details){
            // Extract the characters representing the tens and ones digits of the age
            // It's assumed that the age information starts at index 11 and 12 in each string
            char tens = info.charAt(11);
            char ones = info.charAt(12);
            
            // Check if the person is a senior citizen (age > 60)
            // Explanation:
            // - If the tens digit (info.charAt(11)) is greater than '6', then the age is certainly above 60
            //   because the tens digit represents 70, 80, etc.
            // - If the tens digit is exactly '6', we need to check the ones digit (info.charAt(12)).
            //   If the ones digit is greater than '0', then the age is above 60 (e.g., 61, 62, ..., 69).
            if(tens > '6' || (tens == '6' && ones > '0')) {
                seniorCount++; // Increment the senior count
            }
        }
        
        return seniorCount; // Return the total number of senior citizens
    }
}

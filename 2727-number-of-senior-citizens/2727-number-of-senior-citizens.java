class Solution {
    public int countSeniors(String[] details) {
        // Initialize the counter to count the number of seniors
        int ans = 0;
        
        // Loop through each detail string in the array
        for(int i = 0; i < details.length; i++) {
            // Extract the age from the specific positions (12th and 13th characters)
            // Convert the characters to integers and calculate the age
            int age = (details[i].charAt(11) - '0') * 10 + (details[i].charAt(12) - '0');
            
            // Check if the age is greater than 60
            if(age > 60) {
                // Increment the counter if the person is considered a senior
                ans++;
            }
        }
        
        // Return the total number of seniors
        return ans;
    }
}

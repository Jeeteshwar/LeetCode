class Solution {
    public int minimumDeletions(String s) {
        // Initialize the result (res) to track the number of deletions required
        int res = 0;
        // Initialize count to track the number of 'b' characters encountered
        int count = 0;

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // If the character is 'b', increment the count of 'b's
            if (c == 'b') {
                count++;
            } 
            // If the character is 'a' and there are 'b's encountered before it
            if (c == 'a' && count != 0) {
                // Increment the result since this 'a' is out of order
                res++;
                // Decrement the count, as we're effectively "removing" a 'b' by considering it for deletion
                count--;
            }
        }
        
        // Return the total number of deletions required
        return res;
    }
}

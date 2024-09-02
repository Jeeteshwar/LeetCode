class Solution {
    public int chalkReplacer(int[] chalk, int k) {
     int n = chalk.length;  // Get the number of students (length of the chalk array)
        
        // This loop runs indefinitely until a solution is found
        while(true) {
            // Iterate through each student
            for(int i = 0; i < n; i++) {
                // If k is less than the current student's chalk usage, return the student's index
                if(k < chalk[i]) {
                    return i;
                }
                // Subtract the current student's chalk usage from k
                k -= chalk[i];
            }
        }
    }
}

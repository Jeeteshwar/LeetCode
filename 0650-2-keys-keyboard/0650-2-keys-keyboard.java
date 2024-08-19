class Solution {
    public int minSteps(int n) {
        // Initialize the operation count to 0
        int ope = 0;
        
        // Loop through potential divisors starting from 2 to n
        for(int i = 2; i <= n; i++) {
            // While n is divisible by i, it means i is a factor of n
            while(n % i == 0) {
                // Add i to the operation count
                ope += i;
                // Divide n by i to reduce the problem size
                n /= i;
            }
        }
        
        // Return the total number of operations needed
        return ope;
    }
}

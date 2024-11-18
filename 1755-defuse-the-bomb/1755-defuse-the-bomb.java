class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length; // Get the length of the input array
        int[] result = new int[n]; // Initialize an array to store the result

        // If k is 0, the result is an array of zeros (as no decryption is needed)
        if (k == 0)  
            return result;

        // Iterate through each element in the array
        for (int i = 0; i < n; i++) {
            // Case 1: If k is negative, sum the previous |k| elements
            if (k < 0) {
                for (int j = i - Math.abs(k); j < i; j++) {
                    // Use modular arithmetic to handle circular indexing
                    result[i] += code[(j + n) % n];
                }
            } 
            // Case 2: If k is positive, sum the next k elements
            else {
                for (int j = i + 1; j < i + k + 1; j++) {
                    // Use modular arithmetic to handle circular indexing
                    result[i] += code[j % n];
                }
            }
        }
        
        return result; // Return the resulting array
    }
}

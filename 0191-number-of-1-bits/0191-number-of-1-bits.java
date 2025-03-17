class Solution {
    public int hammingWeight(int n) {
        int res = 0; // Counter to store the number of '1' bits
        int helper = 1; // Helper variable to check each bit of 'n'

        // Loop through all 32 bits of an integer
        for (int i = 0; i < 32; i++) { 
            // Check if the least significant bit is set (1)
            if ((helper & n) != 0) {
                res++; // If bit is 1, increment the counter
            }
            helper <<= 1; // Shift the helper to the left to check the next bit
        }
        return res; // Return the total count of '1' bits
    }
}

/*
Example Walkthrough:

Input: n = 11 (Binary: 1011)

Step-by-step execution:

| Iteration | helper (Binary) | n & helper | res (Count of 1s) | helper <<= 1 (Next) |
|-----------|----------------|------------|----------------|----------------|
| 0         | 00000001       | 00000001 ✔ | 1              | 00000010       |
| 1         | 00000010       | 00000010 ✔ | 2              | 00000100       |
| 2         | 00000100       | 00000000 ✘ | 2              | 00001000       |
| 3         | 00001000       | 00001000 ✔ | 3              | 00010000       |
| ...       | ...            | ...        | ...            | ...            |

Final Output: 3 (Because 11 in binary has three '1's: 1011)
*/

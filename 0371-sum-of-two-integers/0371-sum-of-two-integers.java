class Solution {
    public int getSum(int a, int b) {
        // Keep looping until there is no carry left
        while (b != 0) {
            
            // Step 1: Calculate carry
            // (a & b) gives the common set bits
            // Shifting left (<< 1) moves the carry to the next higher bit
            int carry = (a & b) << 1;

            // Step 2: Add a and b without considering carry
            // XOR (^) adds bits but ignores carry
            a = a ^ b;

            // Step 3: Update b to be the carry
            // Carry still needs to be added in the next iteration
            b = carry;
        }

        // When carry becomes 0, 'a' contains the final sum
        return a;
    }
}

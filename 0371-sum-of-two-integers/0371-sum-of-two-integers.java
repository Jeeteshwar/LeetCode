class Solution {
    public int getSum(int a, int b) {
        // Loop until there is no carry
        while (b != 0) {
            
            // carry = (a & b) << 1
            // AND finds where both a and b have 1 → that means a carry is generated.
            // Example:  5 (0101) & 3 (0011) = 0001, then << 1 = 0010 (carry = 2)
            int carry = (a & b) << 1; 
            
            // a = a ^ b
            // XOR adds without carry (bitwise addition ignoring carry).
            // Truth table reminder:
            // 0 ^ 0 = 0
            // 0 ^ 1 = 1
            // 1 ^ 0 = 1
            // 1 ^ 1 = 0   (carry handled separately)
            // Example:  5 (0101) ^ 3 (0011) = 0110 (6)
            a = a ^ b;
            
            // b = carry
            // We assign carry to b, so in next iteration it will be added.
            b = carry;
        }
        
        // When carry becomes 0, 'a' contains the final sum.
        return a;
    }
}

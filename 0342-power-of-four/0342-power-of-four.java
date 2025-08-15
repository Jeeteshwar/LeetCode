class Solution {
    public boolean isPowerOfFour(int n) {
        if (n == 1) return true;      // base case: 4^0 = 1
        if (n < 1) return false;      // negative numbers or 0 are not powers of 4

        if (n % 4 == 0)               // if divisible by 4
            return isPowerOfFour(n / 4); // reduce the problem

        return false;                 // if not divisible by 4, stop
    }
}

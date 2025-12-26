class Solution {
    public int reverseDigit(int n) {
        int reversed = 0;
        while (n != 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit; // Build reversed number
            n = n / 10; // Remove last digit
        }
        return reversed; 
    }

    public int mirrorDistance(int n) {
        return Math.abs(n - reverseDigit(n));
    }
}
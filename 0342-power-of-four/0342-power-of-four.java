class Solution {
    public boolean isPowerOfFour(int n) {
           if(n < 1) return false; // If n is less than 1, it cannot be a power of four
            if(n == 1) return true;  // If n is 1, it is 4^0, which is a power of four

        if(n % 4 ==0) return isPowerOfFour(n /4); // If n is divisible by 4, recursively check if n/4 is a power of four
        

        
       return false;  // If none of the above conditions are met, n is not a power of four
    }
}
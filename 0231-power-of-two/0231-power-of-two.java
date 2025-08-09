class Solution {
    public boolean isPowerOfTwo(int n) {
        if( n <= 0) return false; // Checking negative 

        if(n==1) return true; // 2^0

        if(n%2==1) return false; // checking odd

        return isPowerOfTwo(n/2); // calling a recursion 
    }
}
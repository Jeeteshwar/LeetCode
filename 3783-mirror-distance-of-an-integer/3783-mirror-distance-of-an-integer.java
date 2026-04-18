class Solution {
    public static int reverse(int n){
        int reverse = 0;

        while(n!= 0){
            int digit = n % 10;
            reverse =  reverse * 10 + digit;
            n /=10;



        }

        return reverse;
    }
    public int mirrorDistance(int n) {
        return Math.abs(reverse(n) - n);
    }
}
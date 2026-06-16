class Solution {
    public int digitSum (int n){
        int sum = 0;
        while(n != 0){
            int digit = n % 10;
            sum += digit;
            n /= 10;

        }
        return sum;
    }
     public int squareSum (int n){
        int sum = 0;
        while(n != 0){
            int digit = n % 10;
            digit *= digit;
            sum += digit;
            n /= 10;

        }
        return sum;
     }
    public boolean checkGoodInteger(int n) {
        return squareSum(n) - digitSum(n) >=50;
    }
}
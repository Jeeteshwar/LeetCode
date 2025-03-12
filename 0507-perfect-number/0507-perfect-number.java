class Solution {
    public boolean checkPerfectNumber(int num) {
        int n = num;

        int sum = 0;
        if(n <= 0){
            return false;
        }

        for(int i = 1 ; i < n ; i++){
            if(n % i == 0){
                sum += i;
            }
        }
        return sum == n;
    }
}
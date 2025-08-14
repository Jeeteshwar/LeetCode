class Solution {
   public int reverse(int num){
    int reversed = 0;
    while(num!= 0){
        int digit = num % 10;
        reversed = reversed * 10 + digit;
        num /= 10;
    }
    return reversed;
   }

    public boolean isSameAfterReversals(int num) {
        int temp = num;
        temp = reverse(temp);
        int tempB = temp;
        tempB = reverse(tempB);
        
        return tempB == num;

    }
}
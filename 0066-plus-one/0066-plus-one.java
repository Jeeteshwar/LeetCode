class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for(int i = n - 1 ; i >= 0 ; i--){ // iterating from last element
            // if the curr element is 9 increment
            if(digits[i] == 9){ // will go for same 99
                digits[i] = 0;

            }
            else{ // increment the last digit by 1
                digits[i]++;
                return digits;
            }
        }
        //edge case // if the arr is 999 and we goes like
        digits = new int [n+1];
        digits[0] = 1;
        return digits;
    }
}
class Solution {
    public int subtractProductAndSum(int nums) {
        int n =(int)Math.log10(nums) + 1;
        int [] digitArr = new int [n];
        int prod = 1;
        int sum = 0;
        

        for(int i = n-1 ; i >= 0 ; i--){
            digitArr[i] = nums % 10;
            nums /= 10;
        }
        for(int i = 0 ; i < digitArr.length ; i++){
            prod *= digitArr[i];
            sum += digitArr[i];
        }

        int diff = prod - sum;
        return diff;
    }
}
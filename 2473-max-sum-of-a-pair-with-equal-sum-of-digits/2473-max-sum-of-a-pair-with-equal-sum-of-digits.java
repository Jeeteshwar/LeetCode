class Solution {
    public int getDigitSum (int n){ // method to get the digitSum
        int sum = 0;
        while(n!=0){
           sum += n % 10;
           n /=10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        int n = nums.length;
        int res = -1; //initialized as -1 if the arr does not have satisfy pair
        int arr [] = new int [82]; // max digitsum 10^9 - 1

        for(int i = 0 ; i < n ; i++){
            int digitSum = getDigitSum(nums[i]); // getting current ele digitSum

            if(arr[digitSum] > 0){ // if the valuse of digit sum already present in the arr eg -> [22,0,11,0]
                res = Math.max(res, nums[i] + arr[digitSum]); // add the max value to res eg : curr + sum present in arr array
            }
            arr[digitSum] = Math.max(arr[digitSum], nums[i]); //adding the max of  current element to the corresponding idx of arr
 
        }
        return res; //finally return 
    }
}
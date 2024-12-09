class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        int [] cumSum = new int [n];

        cumSum[0] = 0;

        for(int i = 1 ; i < n ; i++){
            if(nums[i] % 2 == nums[i - 1] % 2){ // true if both are same partity (odd , odd) 
                                                // false if both are different parity(odd,even)
                cumSum[i] = cumSum[i - 1] + 1; // if true then previous value + 1
            }else{
                cumSum[i] = cumSum[i  - 1]; // else carry the same previous value 

            }
        }
        boolean [] res =  new boolean [m]; // for storing the boolean values

        for(int i = 0 ; i < m ; i++){
            int start =  queries[i][0]; // 2d arr entry 
            int end =  queries[i][1];

            if(cumSum[end] - cumSum[start] == 0){ // if end - start == 0 add true in the bool arr
                res[i] =  true;
            }
            else{
                res[i] = false; // else add false 
            }
        }
        return res; // return the final result
    }
}
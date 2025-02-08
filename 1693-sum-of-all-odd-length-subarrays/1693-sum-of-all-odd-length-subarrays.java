class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int totalSum = 0;

        for(int i = 0 ; i < n ; i++){
            int currSum = 0; // curr sum as 0 will reset after the condition fails
            for(int j = i ; j < n ; j++){ 
                 currSum += arr[j]; // adding curr []]  pointer into curr sum

                if((j - i + 1) % 2 != 0 ){ // checks if the subarray is odd
                   totalSum += currSum; // add the curr sum to the totalSum if and only if the subarray is of                                       odd length
                }

            }
        }
        
        return totalSum;
    }
}
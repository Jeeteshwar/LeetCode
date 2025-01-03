class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;

       
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num; // adding the total sum to the variable
        }

    
        long leftSum = 0;
        int validSplits = 0;

        for (int i = 0; i < n - 1; i++) {
            leftSum += nums[i]; // adding all the elements till the n - 1  
            long rightSum = totalSum - leftSum; // all the diff of total sum  - the left sum
            if (leftSum >= rightSum) {  // checking the valid condition of atleat sum;
                validSplits++; // increment the count of the valid splits
            }
        }

        return validSplits; // return the validspilits
    }
}

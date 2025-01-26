class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int num : nums) totalSum+= num;
        int leftSum = 0;
        int count = 0;

        for(int i = 0 ; i < n - 1 ; i++){
                leftSum += nums[i]; // adding first element in the leftsum beacuse traversing from the left side

                int rightSum = totalSum - leftSum; // totalsum eg 36 - 10 = 26

                if((leftSum % 2) == (rightSum % 2)){ // both of same parity like both odd and both even
                    count++;
                }

        }
        return count;
    }
}
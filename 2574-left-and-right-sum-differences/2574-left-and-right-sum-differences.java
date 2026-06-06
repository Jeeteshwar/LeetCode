class Solution {
    public int[] leftRightDifference(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;


        for(int num : nums) rightSum+= num; 
        // adding the all elements into the rightSum

        for(int i = 0 ; i < nums.length ; i++){ // traverse throught the nums array
            int val = nums[i]; // adding the current elements into val to use it again in the further scenerios
            rightSum -= val; // substracting val from the rightSum
            nums[i] = Math.abs(leftSum - rightSum); // replacing the current idx with abs value of leftRightDifference
           
            leftSum += val; // keep adding the current idx value into the leftSum

        } 
        return nums; // returning the nums with O(1) space
    }
}
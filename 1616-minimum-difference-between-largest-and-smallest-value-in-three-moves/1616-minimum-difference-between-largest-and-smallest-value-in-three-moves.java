class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length; // Getting the length of array

        Arrays.sort(nums); //Sorting in Incresing order

        if(n<=4){ // edge case if array is of less than or equal 4
            return 0;
        }
        int diff = Math.min( 
                           Math.min(nums[n - 1] - nums[3] , nums[n - 2] - nums[2]),     // getting the difference b/w largest and smallest
                           Math.min(nums[n - 3] - nums[1], nums[n - 4] - nums[0])
        );
        return diff; //return diff
    }
}

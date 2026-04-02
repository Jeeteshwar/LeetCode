class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int n = nums.length;
        int minAbs = n;
        for(int i = 0 ; i< n ; i++){
           
            for(int j = i + 1 ; j < n ; j++){
                if(nums[i] == 1 && nums[j] == 2 ||nums[i] == 2 && nums[j] == 1){
                    int currAbs =  Math.abs(i-j);
                    minAbs = Math.min(minAbs , currAbs);
                }
            }

            

        }
        return minAbs == n ? -1 : minAbs;
    }
}
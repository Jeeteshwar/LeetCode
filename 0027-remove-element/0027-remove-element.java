class Solution {
    public int removeElement(int[] nums, int val) {
        int shift=0;
        for(int i = 0 ; i<nums.length ; i++){
            if (nums[i] != val) {
                nums[shift] = nums[i];
                shift++;
            
            }
        }

        return shift;
    }
}

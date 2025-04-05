class Solution {
    public int subsetXORSum(int[] nums) {
        int res=0;
        for(int n : nums) res|=n;
        return res << (nums.length-1);
    }
}
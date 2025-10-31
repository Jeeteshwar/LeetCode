class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res[] = new int[2];
        int index = 0;
    
        for(int i = 1 ; i < n ; i++){
            if(nums[i] == nums[i -1]){
                res[index++] = nums[i];
                if(index == 2) break;
            }
        }
        return res;

    }
}
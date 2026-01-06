class Solution {
    public int[] shuffle(int[] nums, int n) {

        int res [] = new int[nums.length];

       int i = 0;
       int j = n;
       int k = 0;
            
        while(i < n && j < 2 * n){
            res[k++] = nums[i++];
            res[k++] = nums[j++]; 
        }

        for(int x = 0 ; i < n ; i++){
            System.out.print(res[x] + " ");
        }
        return res;
    }
}
class Solution {
    public long countSubarrays(int[] nums, int k) {
    int maxEle = Arrays.stream(nums).max().getAsInt();
    long res =0;
    int left =0;
    int maxicount =0;

    for (int right = 0 ;right < nums.length ; right++ ){

        if(nums[right] == maxEle ) maxicount++;

        while(maxicount == k){
            res+= nums.length - right;
            if(nums[left] == maxEle) maxicount--;
            left++;
        }
    }
    return res;
    }
}
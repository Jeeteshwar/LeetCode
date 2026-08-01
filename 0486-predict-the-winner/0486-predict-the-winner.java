class Solution {
    int bS= 0 ;
    int aS = 0;
    public boolean predictTheWinner(int[] nums) {   
        Integer dp[][] = new Integer[nums.length][nums.length];
        
        return solve(nums,0,nums.length-1,dp)>=0;
    }
    int sum=0; 
    public int solve(int[] nums , int s , int e,Integer [][]dp ){
        if(s>e) return 0;
        if(dp[s][e]!=null) return dp[s][e];    
        int left = nums[s] - solve(nums, s+1, e,dp);
        int right = nums[e] - solve(nums, s, e-1,dp);

        return dp[s][e]=Math.max(left, right);
        
    }
}
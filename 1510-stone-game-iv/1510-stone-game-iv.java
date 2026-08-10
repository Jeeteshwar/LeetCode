class Solution {
    public boolean winnerSquareGame(int n){
        HashSet<Integer> set = new HashSet<>();
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        set.add(1);
        for(int i=1;i<=n;i++){
            if(isSquare(i)){
                set.add(i);
            }
        }
        System.out.println(set);
        return helper(n,set,dp)>0;
    }
    public int helper(int n,HashSet<Integer> set,int[]dp){
        
        if(n==0) return (int) -1e9;
        if(dp[n]!=-1) return dp[n];
        int cur = Integer.MIN_VALUE;
        
        for(int i:set){
            if(i<=n){
                cur = Math.max(cur,i-helper(n-i,set,dp));
            }
        }
        System.out.println(cur);
        return dp[n] = cur;
    }
    public boolean isSquare(int n){
        if (n<0) return false;
        int root = (int) Math.sqrt(n);
        return (root*root==n);
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        int maxPft = 0;
        int currProfit = 0;
        int n = prices.length;

        for(int i = 0 ; i < n-1 ; i++){
            for(int j = i + 1 ; j < n ; j++){
               currProfit =prices[j] - prices[i];
            if(currProfit > maxPft){
                maxPft = Math.max(maxPft ,currProfit);
            }
            }
        }
        return maxPft;
    }
}
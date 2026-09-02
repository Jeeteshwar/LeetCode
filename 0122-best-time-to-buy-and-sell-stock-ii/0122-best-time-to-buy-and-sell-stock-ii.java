class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int total = 0;
        int curr = 0;
        for(int i = 0 ; i < n-1 ; i++){
            if(prices[i+1] - prices[i] > 0){
                 curr = prices[i+1] - prices[i]; 
            } 
        else{
            continue;
        }
        total += curr;

        }
        
        return total;
    }
}
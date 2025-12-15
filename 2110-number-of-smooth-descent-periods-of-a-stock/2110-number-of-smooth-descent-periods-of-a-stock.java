class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long allCount = 0;
        int currCount = 1;

        for(int i = 1 ; i < n ; i++){
             if (prices[i - 1] - prices[i] == 1) {
                currCount++;
            }
            else{
                currCount = 1;
            }
            allCount += currCount;
        
        }
        
        return allCount + 1;
    }
}        
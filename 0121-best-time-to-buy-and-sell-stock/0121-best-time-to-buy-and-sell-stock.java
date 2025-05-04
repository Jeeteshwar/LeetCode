class Solution {
    public int maxProfit(int[] prices) {
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;
    for (int price : prices) {
        minPrice = Math.min(minPrice, price);          // Track lowest price so far
        maxProfit = Math.max(maxProfit, price - minPrice); // Compute max profit
    }
    return maxProfit;
    }
}
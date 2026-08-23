class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0, buy = prices[0];
        for(int i = 1; i < n; i++ ){
            profit = Math.max(profit, prices[i] - buy);
            buy = Math.min(buy, prices[i]);
        }
        return profit > 0 ? profit : 0; 
    }
}
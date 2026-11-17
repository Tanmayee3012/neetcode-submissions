class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return dfs(prices, 0, 1, dp);
    }

    public int dfs(int[] prices, int i, int buy, int[][] dp){
        if(i >= prices.length) return 0;
        if(dp[i][buy] != -1) return dp[i][buy];
        if(buy == 1){
            dp[i][buy] = Math.max(-prices[i] + dfs(prices, i + 1, 0, dp), dfs(prices, i + 1, 1, dp));
        }
        else{
            dp[i][buy] = Math.max(prices[i] + dfs(prices, i + 2, 1, dp), dfs(prices, i + 1, 0, dp));
        }
        return dp[i][buy];
    }
}

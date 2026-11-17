class Solution {
    int res = 0;
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] cache = new int[coins.length + 1][amount + 1];
        for(int[] row: cache){
            Arrays.fill(row, -1);
        }
        return dfs(amount, coins, 0, cache);
    }

    public int dfs(int amount, int[] coins, int i, int[][] cache){
        if(i >= coins.length) return 0;
        if(amount == 0) return 1;
        if(cache[i][amount] != -1) return cache[i][amount];
        int res = 0;
        if(amount >= coins[i]){
            res = dfs(amount, coins, i + 1, cache);
            res += dfs(amount - coins[i], coins, i, cache);
        }
        return cache[i][amount] = res;
    }
}
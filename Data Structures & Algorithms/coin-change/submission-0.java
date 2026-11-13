class Solution {
    HashMap<Integer, Integer> mp = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        int minCoins = dp(coins, amount);
        return (minCoins >= 1e9) ? -1 : minCoins;
    }

    public int dp(int[] coins, int amount){
        if(amount == 0) return 0;
        if(mp.containsKey(amount)) return mp.get(amount);
        int res = Integer.MAX_VALUE;

        for(int coin: coins){
            if(amount - coin >= 0){
                int result = dp(coins, amount - coin);
                if(result != Integer.MAX_VALUE){
                    res = Math.min(res, 1 + result);
                }
            }
        }
        mp.put(amount, res);
        return res;
    }
}

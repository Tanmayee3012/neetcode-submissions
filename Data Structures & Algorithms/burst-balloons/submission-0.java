class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = newNums[n + 1] = 1;
        for(int i = 0; i < n; i++){
            newNums[i + 1] = nums[i];
        }
        int[][] cache = new int[n + 2][n + 2];
        for(int[] row: cache){
            Arrays.fill(row, -1);
        } 
        return dp(newNums, 1, n, cache);
    }

    public int dp(int[] nums, int l , int r, int[][] cache){
        if(l > r) return 0;
        if(cache[l][r] != -1) return cache[l][r];
        cache[l][r] = 0;
        for(int i = l; i <= r; i++){
            int coins = nums[l - 1] * nums[i] * nums[r + 1];
            coins += dp(nums, l, i - 1, cache) + dp(nums, i + 1, r, cache);
            cache[l][r] = Math.max(cache[l][r], coins);
        }
        return cache[l][r];
    }

}

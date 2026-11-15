class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] cache = new int[n][n + 1];
        for(int[] row: cache){
            Arrays.fill(row, -1);
        }
        return dfs(nums, 0, -1, cache);
    }

    public int dfs(int[] nums, int i, int j, int[][] cache){
        if(i == nums.length) return 0;
        if(cache[i][j + 1] != -1) return cache[i][j + 1];
        int temp = Integer.MIN_VALUE;
        if(j == -1 || nums[j] < nums[i]){
            temp =  1 + dfs(nums, i + 1, i, cache);
        }
        return cache[i][j + 1] = Math.max(temp, dfs(nums, i + 1, j, cache));
    }
}

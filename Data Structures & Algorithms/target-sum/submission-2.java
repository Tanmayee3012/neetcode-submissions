class Solution {
    int totalSum;
    public int findTargetSumWays(int[] nums, int target) {
        totalSum = 0;
        for(int num: nums){
            totalSum += num;
        }
        int[][] cache = new int[nums.length + 1][2 * totalSum + 1];
        for(int[] row: cache){
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return dfs(nums, target, 0, 0, cache);
    }

    public int dfs(int[] nums, int target, int i, int total, int[][] cache){
        if(i == nums.length) return target == total ? 1 : 0;
        if(cache[i][total + totalSum] != Integer.MIN_VALUE) return cache[i][total + totalSum];
        return cache[i][total + totalSum] = dfs(nums, target, i + 1, total + nums[i], cache) + dfs(nums, target, i + 1, total - nums[i], cache);
    }
}
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        Boolean[][] cache = new Boolean[nums.length][sum / 2 + 1];
        if(sum % 2 != 0){
            return false;
        }
        return dfs(nums, 0, sum / 2, cache);
    }

    public boolean dfs(int[] nums, int i, int target, Boolean[][] cache){
        if(i == nums.length) return target == 0;
        if(target < 0) return false;
        if(cache[i][target] != null) return cache[i][target];
        return cache[i][target] = dfs(nums, i + 1, target, cache) || dfs(nums, i + 1, target - nums[i], cache);
    }
}

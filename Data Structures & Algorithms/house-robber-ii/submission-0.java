class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] cache1 = new int[nums.length];
        Arrays.fill(cache1, -1);
        int[] cache2 = new int[nums.length];
        Arrays.fill(cache2, -1);
        int ans = Math.max(dp(nums, 0, nums.length - 2, cache1), dp(nums, 1, nums.length - 1, cache2));
        return ans;
    }

    public int dp(int[] nums, int i, int end, int[] cache){
        if(i > end) return 0;
        if(cache[i] != -1) return cache[i];
        if(i == nums.length - 1){
            if(cache[0] != -1) return 0;
        }
        return cache[i] = Math.max(nums[i] + dp(nums, i + 2, end, cache), dp(nums, i + 1, end, cache));
    }
}
class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0 , target, res, subset);
        return res;
    }

    public void dfs(int[] nums, int i, int target, List<List<Integer>> res, List<Integer> subset){
        if(target == 0){
            res.add(new ArrayList<>(subset));
            return;
        }

        if(i >= nums.length || target < 0) return;

        subset.add(nums[i]);
        dfs(nums, i , target - nums[i], res, subset);
        subset.remove(subset.size() - 1);
        dfs(nums, i + 1, target, res, subset);
    }
}

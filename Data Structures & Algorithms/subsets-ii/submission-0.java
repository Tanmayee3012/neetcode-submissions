class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, subset, res);
        return res; 
    }

    public void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> res){
        if(i >= nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        
        subset.add(nums[i]);
        if(!res.contains(subset) || (i > 0 && nums[i] != nums[i - 1])) {
            dfs(nums, i + 1, subset, res);
        }
        subset.remove(subset.size() - 1);
        dfs(nums, i + 1, subset, res);
    }
}

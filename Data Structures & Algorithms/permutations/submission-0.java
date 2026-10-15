class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, subset, res);
        return res; 
    }

    public void dfs(int[] nums, List<Integer> subset, List<List<Integer>> res){
        if(nums.length == subset.size()){
            res.add(new ArrayList<>(subset));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(subset.contains(nums[i])) continue;
            subset.add(nums[i]);
            dfs(nums, subset, res);
            subset.remove(subset.size() - 1);
        }
    }
}
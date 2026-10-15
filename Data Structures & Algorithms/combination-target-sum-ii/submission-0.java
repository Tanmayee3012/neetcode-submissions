class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, subset, res);
        return res; 
    }

    public void dfs(int[] candidates, int target, int start, List<Integer> subset, List<List<Integer>> res){
        if(target == 0) {
            res.add(new ArrayList<>(subset));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(i > start && candidates[i] == candidates[i - 1]) continue;
            if(candidates[i] > target) break;
            subset.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, subset, res);
            subset.remove(subset.size() - 1);
        }
    }
}
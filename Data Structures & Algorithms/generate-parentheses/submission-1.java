class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder subset = new StringBuilder();
        dfs( 0, n, subset, res, 0, 0);
        return res; 
    }

    public void dfs(int i, int n, StringBuilder subset, List<String> res, int openPar, int closePar){
        if(i == 2 * n && openPar == closePar){
            res.add(subset.toString());
            return;
        }
        if(openPar < n) {
            subset.append('(');
            dfs(i + 1, n, subset, res, openPar + 1, closePar);
            subset.deleteCharAt(subset.length() - 1);
        }
        if(openPar > closePar) {
            subset.append(')');
            dfs(i + 1, n, subset , res, openPar, closePar + 1);
            subset.deleteCharAt(subset.length() - 1);
        }
    }
}
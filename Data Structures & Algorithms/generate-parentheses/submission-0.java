class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String subset = new String();
        dfs( 0, n, subset, res, 0, 0);
        return res; 
    }

    public void dfs(int i, int n, String subset, List<String> res, int openPar, int closePar){
        if(i == 2 * n && openPar == closePar){
            res.add(new String(subset));
            return;
        }
        if(openPar < n) {
            dfs(i + 1, n, subset + '(', res, openPar + 1, closePar);
        }
        if(openPar > closePar) {
            dfs(i + 1, n, subset + ')', res, openPar, closePar + 1);
        }
    }
}
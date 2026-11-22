class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        Boolean[][] cache = new Boolean[n + 1][m + 1];
        return dfs(s, p, 0, 0, cache);
    }

    public boolean dfs(String s, String p, int i, int j, Boolean[][] cache){
        int n = s.length(), m = p.length();
        if(cache[i][j] != null) return cache[i][j];
        if(j == m) return i == n;
        boolean match = i < n && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j));
        if(j + 1 < m && p.charAt(j + 1) == '*'){
            return cache[i][j] = dfs(s, p, i, j + 2, cache) || (match && dfs(s, p, i + 1, j, cache));
        }
        if(match){
            return cache[i][j] = dfs(s, p, i + 1, j + 1, cache);
        }
        return cache[i][j] = false;
    }
}

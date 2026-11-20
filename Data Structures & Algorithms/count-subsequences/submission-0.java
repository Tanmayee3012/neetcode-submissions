class Solution {
    public int numDistinct(String s, String t) {
        if(t.length() > s.length()) return 0;
        int[][] cache = new int[s.length() + 1][t.length() + 1];
        for(int[] row: cache){
            Arrays.fill(row, -1);
        }
        return dfs(s, t, 0, 0, cache);
    }

    public int dfs(String s, String t, int i , int j, int[][] cache){
        if(i >= s.length() && j < t.length()) return 0;
        if(j == t.length()) return 1;
        if(cache[i][j] != -1) return cache[i][j];
        int res = 0;
        res += dfs(s, t, i + 1, j, cache);
        if(s.charAt(i) == t.charAt(j)){
            res += dfs(s, t, i + 1, j + 1, cache);
        }
        return cache[i][j] = res;
    }
}

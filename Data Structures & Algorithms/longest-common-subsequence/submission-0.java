class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] cache = new int[text1.length() + 1][text2.length() + 1];
        for(int[] row: cache){
            Arrays.fill(row, -1);
        }
        return dfs(text1, text2, 0 , 0, cache);
    }

    public int dfs(String text1, String text2, int i, int j, int[][] cache){
        if(i >= text1.length() || j >= text2.length()) return 0;
        if(cache[i][j] != -1) return cache[i][j];
        if(text1.charAt(i) == text2.charAt(j)){
            return cache[i][j] = 1 + dfs(text1, text2, i + 1, j + 1, cache);
        } 
        return cache[i][j] = Math.max(dfs(text1, text2, i + 1, j, cache), dfs(text1, text2, i , j + 1, cache));
    }
}
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] cache = new int[m + 1][n + 1]; 
        for(int[] row: cache){
            Arrays.fill(row, -1);
        }
        return dp(word1, word2, 0, 0, cache);
    }

    public int dp(String w1, String w2, int i, int j, int[][] cache){
        int m = w1.length(), n = w2.length();
        if(i == m) return n - j;
        if(j == n) return m - i;
        if(cache[i][j] != -1) return cache[i][j];
        if(w1.charAt(i) == w2.charAt(j)){
            return cache[i][j] = dp(w1, w2, i + 1, j + 1, cache);
        }
        int ans = Math.min(dp(w1, w2, i + 1, j, cache), dp(w1, w2, i, j + 1, cache));
        ans = Math.min(ans, dp(w1, w2, i + 1, j + 1, cache));
        return cache[i][j] = ans + 1;
    }
}

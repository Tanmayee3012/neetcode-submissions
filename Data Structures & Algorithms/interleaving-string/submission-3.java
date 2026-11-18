class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.isEmpty() && s2.isEmpty() && s1.isEmpty()) return true;
        if(s1.length() + s2.length() != s3.length()) return false;
        Boolean[][] cache = new Boolean[s1.length() + 1][s2.length() + 1];
        return dfs(s1, s2, s3, 0, 0, 0, cache);
    }

    public boolean dfs(String s1, String s2, String s3, int i , int j, int k, Boolean[][] cache){
        if(k == s3.length()) return (i == s1.length() && j == s2.length());
        if(cache[i][j] != null) return cache[i][j];
        boolean ans = false;
        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
            ans = ans || dfs(s1, s2, s3, i + 1, j, k + 1, cache);
        } 
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)){
            ans = ans || dfs(s1, s2, s3, i , j + 1, k + 1, cache);
        }
        return cache[i][j] = ans;
    }
}

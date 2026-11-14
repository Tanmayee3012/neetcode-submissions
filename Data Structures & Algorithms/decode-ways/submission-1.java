class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[n] = 1;
        return dfs(s, 0, cache);
    }

    public int dfs(String s, int i, int[] cache){
        if(cache[i] != -1) return cache[i];
        if(s.charAt(i) == '0') return 0;

        int res = dfs(s, i + 1, cache);
        if(i < s.length() - 1){
            if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7')){
                res += dfs(s, i + 2, cache);
            }
        }
        return cache[i] = res;
    }
}

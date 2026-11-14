class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[n] = 1;
        return dfs(s, wordDict, 0, cache);
    }

    public boolean dfs(String s, List<String> wordDict, int i, int[] cache){
        if(cache[i] != -1) {
            return cache[i] == 1 ? true : false;
        }

        for(String w: wordDict){
            if(i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)){
                if(dfs(s, wordDict, i + w.length(), cache)) {
                    cache[i] = 1;
                    return true;
                }
            }
        }
        cache[i] = 0;
        return false;
    }
}

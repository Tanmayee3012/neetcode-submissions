class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hash = new HashMap<>();
        int l = 0, res = 0;
        char[] chars = s.toCharArray();
        for(int r = 0; r < s.length(); r++){
            if(hash.containsKey(chars[r])){
                l = Math.max(l, hash.get(chars[r]) + 1);
            }
            hash.put(chars[r], r);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}

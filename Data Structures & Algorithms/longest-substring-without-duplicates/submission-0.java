class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hash = new HashSet<>();
        int l = 0, r = 0, res = 0;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            while(hash.contains(chars[i])){
                hash.remove(chars[l]);
                l++;
            }
            hash.add(chars[i]);
            r = i; 
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}

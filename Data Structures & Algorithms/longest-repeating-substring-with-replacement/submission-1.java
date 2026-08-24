class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        int res = 0, l = 0, maxf=0;
        char[] chars = s.toCharArray();
        for(int r = 0; r < chars.length; r++){
            count.put(chars[r], count.getOrDefault(chars[r], 0) + 1);
            maxf = Math.max(maxf, count.get(chars[r]));
            if((r - l + 1) - maxf > k){
                count.put(chars[l], count.get(chars[l]) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}

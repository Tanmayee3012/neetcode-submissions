class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        for(int i = 0; i < s1.length(); i++){
            hash1[s1.charAt(i)-'a']++;
            hash2[s2.charAt(i)-'a']++;
        }

        int r = s1.length();
        for(int l = 0; l < s2.length() && r < s2.length(); l++){
            if(Arrays.equals(hash1, hash2)) return true;
            hash2[s2.charAt(l)-'a']--;
            hash2[s2.charAt(r)-'a']++;
            r++;
        }
        if(Arrays.equals(hash1, hash2)) return true;
        return false;
    }
}

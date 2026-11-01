class Solution {
    public List<List<String>> partition(String s) {
       List<List<String>> res = new ArrayList<>();
        List<String> subset = new ArrayList<>();
        backtrack(res, subset, 0, s);
        return res;
    }

    public void backtrack(List<List<String>> res, List<String> subset, int start, String s){ 
        if(start == s.length()) {
            res.add(new ArrayList<>(subset));
            return;
        }

        for(int i = start; i < s.length(); i++){
            if(!isPalindrome(s.substring(start, i + 1))) continue;
            subset.add(s.substring(start, i + 1));
            backtrack(res, subset, i + 1, s);
            subset.remove(subset.size() - 1);
        }
    }

    public boolean isPalindrome(String sub){
        int si = 0, li = sub.length() - 1;
        while(si < li){
            if(sub.charAt(si) != sub.charAt(li)) return false; 
            si++;
            li--;
        }
        return true;
    }
}
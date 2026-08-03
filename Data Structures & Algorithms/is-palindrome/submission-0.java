class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        char[] c = s.toCharArray();
        while(i<=j){
            while(i < j && !isAlphaNum(c[i])){
                i++;
            }
            while(j > i && !isAlphaNum(c[j])){
                j--;
            }
            if(Character.toLowerCase(c[i]) != Character.toLowerCase(c[j])) return false; 
                i++;
                j--;
            }
            return true;
        }

        public boolean isAlphaNum(char c){
             return ((c >= 'A' && c <= 'Z') ||
              (c >= 'a' && c <= 'z') ||
              (c >= '0' && c <= '9')) ;
        }
    }


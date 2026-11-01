class Solution {
    public class Phone{
        int digit;
        String letters;
        Phone(int digit){
            if(digit == 2){
                this.digit = digit;
                letters="abc";
            } else if(digit == 3){
                this.digit = digit;
                letters="def";
            } else if(digit == 4){
                this.digit = digit;
                letters="ghi";
            } else if(digit == 5){
                this.digit = digit;
                letters="jkl";
            } else if(digit == 6){
                this.digit = digit;
                letters="mno";
            } else if(digit == 7){
                this.digit = digit;
                letters="pqrs";
            } else if(digit == 8){
                this.digit = digit;
                letters="tuv";
            } else if(digit == 9){
                this.digit = digit;
                letters="wxyz";
            } 
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuilder subset = new StringBuilder();
        if(digits.equals("")) return new ArrayList<>();
        dfs(digits, res, subset, 0);
        return res; 
    }

    public void dfs(String digits, List<String>res, StringBuilder subset, int start){
        if(start >= digits.length()){
            res.add(new String(subset.toString()));
            return;
        }

        Phone p = new Phone(digits.charAt(start) - '0');
        for(int i = 0; i < p.letters.length(); i++){
            subset.append(p.letters.charAt(i));
            dfs(digits, res, subset, start + 1);
            subset.deleteCharAt(subset.length() - 1);
        }
    }
}
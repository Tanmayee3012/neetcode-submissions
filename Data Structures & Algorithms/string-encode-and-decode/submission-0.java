class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(String str: strs){
            res.append(str.length()).append('#').append(str);
        }
        System.out.println(res.toString());
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0,j;
        while(i < str.length()){
            j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            i = j + 1;
            j = i + length;
            res.add(str.substring(i,j));
            i = j;
        }
        return res;
    }
}

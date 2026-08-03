class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num: nums){
            numSet.add(num);
        }
        int res = 0, curr = 0;
        for(int num: numSet){
            if(!numSet.contains(num-1)){
                int length = 1;
                while(numSet.contains(num+length)){
                    length++;
                }
                res = Math.max(length,res);
            }
        }
        return res;
    }
}

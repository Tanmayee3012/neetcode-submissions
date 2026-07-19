class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> count = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length ; i++){
            count.put(nums[i],i);
        }
        for(int i=0; i<nums.length; i++){
            int complement = target-nums[i];
            var complementIndex = count.get(complement);
            if( complementIndex!=null) {
                if(count.containsKey(complement)  & i != complementIndex){
                    return new int[]{i,complementIndex};
                }
            }
        }
        return null;
    }
}

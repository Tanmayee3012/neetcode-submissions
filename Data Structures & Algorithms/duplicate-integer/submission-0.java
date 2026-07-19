class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer,Integer> counts = new HashMap<Integer,Integer>();
        for (int i=0; i<nums.length; i++)
        {
            if(counts.get(nums[i]) != null) return true;
            counts.put(nums[i],1);
        }
        return false;
    }
}
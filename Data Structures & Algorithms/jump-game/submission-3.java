class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int goal = n - 1;
        int i;
        for(i = n - 2; i >= 0; i--){
            if(i + nums[i] >= goal){
                goal = i;
            }
        }
        return goal == 0;
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], tempSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(tempSum < 0){
                tempSum = 0;
            } 
            tempSum += nums[i];
            maxSum = Math.max(maxSum, tempSum);
        }
        return maxSum;
    }
}

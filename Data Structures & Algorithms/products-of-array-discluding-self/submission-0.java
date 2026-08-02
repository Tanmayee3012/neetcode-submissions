class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int leftCurr = 1, rightCurr = 1;
        for(int i = 0; i < n; i++){
            leftCurr *= nums[i];
            left[i] = leftCurr;
        }

        for(int i = n-1; i > 0; i--){
            rightCurr *= nums[i];
            right[i] = rightCurr;
        }

        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            if(i == 0) res[i] = right[i+1];
            else if(i == n-1) res[i] = left[i-1];
            else res[i] = left[i-1] * right[i+1];
        }
        return res;
    }
}  

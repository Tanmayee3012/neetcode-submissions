class Solution {
    public int findMin(int[] nums) {
        int n = nums.length, l = 0, r = n - 1, mid = 0, ans = nums[0];
        while(l <= r){
            if (nums[l] < nums[r]) {
                ans = Math.min(ans, nums[l]);
                break;
            }
            mid = (l + r) / 2; 
            if(nums[l] <= nums[mid]) l = mid + 1;
            else if(nums[r] > nums[mid]) r = mid - 1;
            ans = Math.min(nums[mid], ans);
        }
        return ans;
    }
}

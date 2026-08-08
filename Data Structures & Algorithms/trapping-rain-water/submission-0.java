class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1, res = 0, ml = height[l], mr = height[r];
        while(l < r){
            if(height[l] <= height[r]){
                l++;
                ml = Math.max(ml, height[l]);
                res += ml - height[l];
            } else {
                r--; 
                mr = Math.max(mr, height[r]);
                res += mr - height[r];
            }
        }
        return res;
    }
}

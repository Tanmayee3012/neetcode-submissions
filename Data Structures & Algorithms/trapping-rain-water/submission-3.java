class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int l=0,ml=0,mr=0,r=n-1,res=0;
        while(l<=r){
            if(height[l]<height[r]){
                if(height[l]>=ml) ml=height[l];
                else res+=ml-height[l];
                l++;
            }
            else{
                if(height[r]>=mr) mr=height[r];
                else res+=mr-height[r];
                r--;
            }
        }
        return res;
    }
}

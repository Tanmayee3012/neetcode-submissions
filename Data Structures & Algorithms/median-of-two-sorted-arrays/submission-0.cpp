class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        vector<int>v;
        for(auto num:nums1)  
            v.push_back(num);
        for(auto num:nums2)  
            v.push_back(num);
        sort(v.begin(),v.end());
        int tot=v.size();
        if(tot%2==0)
        {
            return (float(v[tot/2])+float(v[tot/2-1]))/2.00;
        }
        else{
            return float(v[tot/2]);
        }
    }
};
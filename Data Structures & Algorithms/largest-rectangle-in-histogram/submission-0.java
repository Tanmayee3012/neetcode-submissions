class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, maxArea = 0;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
                int curr = st.pop();
                maxArea = Math.max(maxArea, heights[curr] * (i - (st.isEmpty() ? -1 : st.peek()) - 1)); 
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int curr = st.pop();
            if(!st.isEmpty()){
                maxArea = Math.max(maxArea, heights[curr] * (n - (st.isEmpty() ? -1 : st.peek()) - 1));
            } else {
                maxArea = Math.max(maxArea, heights[curr] * n);
            }
        }
        return maxArea;
    }
}
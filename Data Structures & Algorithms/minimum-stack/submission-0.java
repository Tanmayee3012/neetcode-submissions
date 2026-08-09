class MinStack {
    private Stack<int[]> st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new int[] {val, val});
        } else {
            int curMin = st.peek()[1];
            st.push(new int[]{val, Math.min(val, curMin)});
        }
        
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek()[0];
    }
    
    public int getMin() {
        return st.peek()[1];
    }
}

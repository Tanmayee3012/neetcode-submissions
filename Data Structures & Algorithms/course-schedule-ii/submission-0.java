class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] vis = new int[numCourses];
        Stack<Integer> st = new Stack<Integer>();
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }

        for(int i = 0; i < numCourses; i++){
            if(vis[i] == 0){
                if(dfs(i, adj, st, vis)) return new int[0];
            }
        }

        int[] ans = new int[numCourses];
        int i = 0;
        while(!st.isEmpty()){
            ans[i++] = st.peek();
            st.pop();
        }
        return ans;
    }

    public boolean dfs(int node, List<List<Integer>> adj, Stack<Integer> st, int[] vis){
        vis[node] = 1;
        for(int it: adj.get(node)){
            if(vis[it] == 1) return true;
            if(vis[it] == 0)
                if(dfs(it, adj, st, vis)) return true;
        }
        vis[node] = 2;
        st.push(node);
        return false;
    }
}
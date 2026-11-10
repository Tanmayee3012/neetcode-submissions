class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] vis = new int[n];
        int components = 0;
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                components++;
                dfs(i, -1, vis, adj);
            }
        }
        return components;
    }

    public void dfs(int i, int par, int[] vis, List<List<Integer>> adj){
        vis[i] = 1;
        for(int it: adj.get(i)){
            if(it == par) continue;
            if(vis[it] == 0){
                dfs(it, i, vis, adj);
            }
        }
        return;
    }
}

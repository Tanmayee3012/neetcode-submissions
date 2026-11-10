class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] vis = new int[n];
        boolean ans = true;
        int components = 0;
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                components++;
                if(components > 1) return false;
                if(!dfs(i, adj, -1, vis)) return false;
            }
        }
        return true;
    }

    public boolean dfs(int i, List<List<Integer>> adj, int par, int[] vis){
        vis[i] = 1;
        for(int it: adj.get(i)){
            if (it == par) continue;
            if(vis[it] == 1) return false;
            if(vis[it] == 0) {
                if(!dfs(it, adj, i, vis)) return false;
            }
        }
        return true;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] par = new int[n + 1];
        for(int i = 0; i < n; i++){
            par[i] = i;
        }
        int[] rank = new int[n + 1];
        Arrays.fill(rank, 1);

        for(int[] edge: edges){
            if(!union(edge[0], edge[1], par, rank)) return new int[]
{edge[0], edge[1]};      
        }
        return new int[]{0, 0};
    }

    public int find(int a, int[] par){
        if(par[a] != a) return par[a] = find(par[a], par);
        return par[a];
    }

    public boolean union(int u, int v, int[] par, int[] rank){
        int p1 = find(u, par);
        int p2 = find(v, par);
        if(p1 == p2) return false;
        if(rank[p1] > rank[p2]){
            par[p2] = p1;
            rank[p1] += rank[p2];
        } else{
            par[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}
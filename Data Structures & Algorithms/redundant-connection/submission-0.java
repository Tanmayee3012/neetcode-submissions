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
            if(!union(edge[0], edge[1], rank, par)) {
                return new int[]{edge[0], edge[1]};
            }
        }
        return new int[]{0,0};
    }

    public int find(int i, int[] par){
        if(i != par[i]){
            par[i] = find(par[i], par);
        }
        return par[i];
    }

    public boolean union(int n1, int n2, int[] rank, int[] par){
        int p1 = find(n1, par);
        int p2 = find(n2, par);
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
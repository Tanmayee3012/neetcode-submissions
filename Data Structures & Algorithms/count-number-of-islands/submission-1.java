class Solution {
    class Pair {
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    int[] dRow = {-1, 0, 1, 0};
    int[] dCol = {0, 1, 0, -1};

    public void dfs(int ro, int co, char[][] grid, int[][] vis){
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < 4; i++){
            int nrow = ro + dRow[i];
            int ncol = co + dCol[i];
            if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1'){
                vis[nrow][ncol] = 1;
                dfs(nrow, ncol, grid, vis);
            } 
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && grid[i][j] == '1'){
                    count++;
                    dfs(i , j, grid, vis);
                }
            }
        }
        return count;
    }
}

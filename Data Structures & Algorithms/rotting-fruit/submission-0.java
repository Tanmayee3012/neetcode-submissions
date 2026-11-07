class Solution {
    public int orangesRotting(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        int fresh = 0;
        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                } else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;

        int[][] dirs = new int[][]{{0, -1}, {-1, 0}, {0 , 1}, {1, 0}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] node = q.poll();
                int r = node[0];
                int c = node[1];

                for(int[] dir: dirs){
                    int nrow = r + dir[0];
                    int ncol = c + dir[1];
                    if(nrow < 0 || ncol < 0 || nrow >= ROW || ncol >= COL || grid[nrow][ncol] != 1) continue;
                    grid[nrow][ncol] = 2;
                    fresh--;
                    q.add(new int[]{nrow, ncol});
                }   
            }
            if(!q.isEmpty()){
                time++;
            }
        }
        return fresh == 0 ? time : -1;
    }
}
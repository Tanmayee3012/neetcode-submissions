class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[][] vis = new int[n][n];
        int[][] dirs =  {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        pq.offer(new int[]{grid[0][0], 0, 0});

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int r = node[1];
            int c = node[2];
            int timeSoFar = node[0];
            vis[r][c] = 1;
            if(r == n - 1 && c == n -1) return timeSoFar;

            for(int[] dir: dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nr < n && nc >=0 && nc < n){
                    if(vis[nr][nc] == 0){
                        int newTime = Math.max(timeSoFar, grid[nr][nc]);
                        pq.offer(new int[]{newTime, nr, nc});
                    }
                }
            }
        }
        return -1;
    }
}

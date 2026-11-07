class Solution {
    private int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;

        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] alt = new boolean[ROWS][COLS];

        Queue<int[]> pacq = new LinkedList<>();
        Queue<int[]> altq = new LinkedList<>();

        for(int c = 0; c < COLS; c++){
            pacq.add(new int[]{0, c});
            altq.add(new int[]{ROWS - 1, c});
        }

        for(int r = 0; r < ROWS; r++){
            pacq.add(new int[]{r, 0});
            altq.add(new int[]{r, COLS - 1});
        }

        bfs(pacq, pac, heights);
        bfs(altq, alt, heights);

        List<List<Integer>> res = new ArrayList<>();
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(pac[r][c] && alt[r][c]){
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        return res;
    }

    public void bfs(Queue<int[]> q, boolean[][] ocean, int[][] heights){
        int ROWS = heights.length;
        int COLS = heights[0].length;
        while(!q.isEmpty()){
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            ocean[row][col] = true;
            for(int[] dir: dirs){
                int nrow = row + dir[0];
                int ncol = col + dir[1];

                if(nrow >= 0 && ncol >= 0 && nrow < ROWS && ncol < COLS && !ocean[nrow][ncol] && heights[nrow][ncol] >= heights[row][col]){
                    q.add(new int[]{nrow, ncol});
                }

            }
        }
    }
}

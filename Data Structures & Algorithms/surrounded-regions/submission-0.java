class Solution {
    public void solve(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;

        boolean[][] vis = new boolean[ROWS][COLS];
        Queue<int[]> q = new LinkedList<>();

        for(int r = 0; r < ROWS; r++){
            if(board[r][0] == 'O') q.add(new int[]{r , 0});
            if(board[r][COLS - 1] == 'O') q.add(new int[]{r , COLS - 1});
        }

        for(int c = 0; c < COLS; c++){
            if(board[0][c] == 'O') q.add(new int[]{0 , c});
            if(board[ROWS - 1][c] == 'O')  q.add(new int[]{ROWS - 1 , c});
        }

        bfs(vis, board, q);

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(!vis[r][c] && board[r][c] == 'O'){
                    board[r][c] = 'X';
                }
            }
        }
    }

    private int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public void bfs(boolean[][] vis, char[][] board, Queue<int[]> q){
        int ROWS = board.length;
        int COLS = board[0].length;

        while(!q.isEmpty()){
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
            vis[r][c] = true;
            for(int[] dir: dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS && !vis[nr][nc] && board[nr][nc] == 'O'){
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}
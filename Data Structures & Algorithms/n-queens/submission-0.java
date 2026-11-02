class Solution {
    public boolean isSafe(int row, int col, int n, char[][] board){
        int duprow = row;
        int dupcol = col;

        while(col >= 0){
            if(board[row][col] == 'Q') return false;
            col--;
        }

        row = duprow;
        col = dupcol;
        while(row >=0 && col >= 0){
            if(board[row][col] == 'Q') return false;
            col--;
            row--;
        }

        row = duprow;
        col = dupcol;
        while(row < n && col >= 0){
            if(board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(0, board, res, n);
        return res;
    }

    public void dfs(int col, char[][] board, List<List<String>> res, int n){
        if(col == n){
            res.add(construct(board));
            return;
        }

        for(int row = 0; row < n; row++){
            if(isSafe(row, col, n, board)){
                board[row][col] = 'Q';
                dfs(col + 1, board, res, n);
                board[row][col] = '.';
            }
        }
    }

    private List<String> construct(char[][] board) {
        List<String> currentBoard = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            currentBoard.add(new String(board[i]));
        }
        return currentBoard;
    }
}
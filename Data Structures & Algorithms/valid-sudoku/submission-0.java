class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int [9][9];
        int[][][] blocks = new int[3][3][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int number=board[i][j]-'1';
                    if(row[i][number]++ > 0) return false;
                    if(col[j][number]++ > 0) return false;
                    if(blocks[i/3][j/3][number]++ > 0) return false;
                }
            }
        }
        return true;
    }
}

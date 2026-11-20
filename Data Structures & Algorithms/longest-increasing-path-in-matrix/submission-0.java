class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] cache = new int[n][m];
        for(int[] row: cache){
            Arrays.fill(row, -1);
        }
        int LIP = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                LIP = Math.max(LIP, dfs(matrix, i, j, Integer.MIN_VALUE, cache));
            }
        }
        return LIP;
    }

    public int dfs(int[][] matrix, int i, int j, int preVal, int[][] cache){
        int ROWS = matrix.length, COLS = matrix[0].length;
        if(i >= ROWS || j >= COLS || i < 0 || j < 0 || matrix[i][j] <= preVal) return 0;
        if(cache[i][j] != -1) return cache[i][j];
        int res = 1;
        for(int[] dir: dirs){
            res = Math.max(res, 1 + dfs(matrix, i + dir[0], j + dir[1], matrix[i][j], cache));
        }
        return cache[i][j] = res;
    }
}
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, n = matrix.length, m = matrix[0].length, high = m * n - 1, mid;
        while(low <= high){
            mid = (low + high) / 2;
            int r = mid / m, c = mid % m;
            if(matrix[r][c] == target) return true;
            else if(matrix[r][c] < target) low = mid + 1;
            else if(matrix[r][c] > target) high = mid - 1;
        }
        return false;
    }
}
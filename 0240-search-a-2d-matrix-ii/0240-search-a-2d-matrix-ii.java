class Solution {
    int m;
    int n;

    public boolean searchMatrix(int[][] matrix, int target) {
        m = matrix.length;
        n = matrix[0].length;

        return binarySearch(matrix, target, 0, n - 1);
    }
    public boolean binarySearch(int[][] matrix, int target, int i, int j) {
        if (i < 0 || i == m || j < 0 || j == n) {
            return false;
        }
        int val = matrix[i][j];

        if (matrix[i][j] == target) {
            return true;
        }
        else if (val > target) {
            return binarySearch(matrix, target, i, j - 1);
        }
        else {
            return binarySearch(matrix, target, i+1, j);
        }
    }
}
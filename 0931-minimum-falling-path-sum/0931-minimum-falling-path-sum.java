class Solution {
    int n;
    int dp[][];

    public int minFallingPathSum(int[][] matrix) {
        n = matrix.length;
        int res = Integer.MAX_VALUE;
        dp = new int[n+1][n+1]; 

        for (int arr[]: dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        for (int col = 0; col < n; col++) {
            int val = solve(matrix, 0, col);
            res = Math.min(res, val);
        }

        return res;
    }
    public int solve(int matrix[][], int i, int j) {

        if (j < 0 || j == n) {
            return Integer.MAX_VALUE;
        }

        if (i == n - 1) {
            return matrix[i][j];
        }

        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }

        int left = Integer.MAX_VALUE; 
        if (j > 0) {
            left = matrix[i][j] + solve(matrix, i+1, j-1);
        }
        int down = matrix[i][j] + solve(matrix, i+1, j);
        int right = Integer.MAX_VALUE;
        if (j < n - 1) {
            right = matrix[i][j] + solve(matrix, i+1, j+1);
        }

        return dp[i][j] = Math.min(left, Math.min(down, right));
    } 
}
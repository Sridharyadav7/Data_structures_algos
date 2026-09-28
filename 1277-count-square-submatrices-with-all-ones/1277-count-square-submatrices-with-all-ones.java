class Solution {
    int m;
    int n;
    int dp[][];

    public int countSquares(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int ans = 0;
        dp = new int[m+1][n+1];

        for (int arr[]: dp) {
            Arrays.fill(arr, -1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans += solve(matrix, i, j);
            }
        }
        return ans;
    }
    public int solve(int[][] matrix, int i, int j) {
        if (i == m || j == n || matrix[i][j] == 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int right = solve(matrix, i, j+1);
        int diagonal = solve(matrix, i+1, j+1);
        int below = solve(matrix, i+1, j);

        return dp[i][j] = 1 + Math.min(right, Math.min(diagonal, below));
    }
}
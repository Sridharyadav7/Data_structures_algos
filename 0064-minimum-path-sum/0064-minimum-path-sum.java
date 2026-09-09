class Solution {
    int m;
    int n;
    int dp[][];

    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1) {
                    dp[i][j] = dp[i][j-1] + grid[i-1][j-1];
                }
                else if (j == 1) {
                    dp[i][j] = dp[i-1][j] + grid[i-1][j-1];
                }
                else {
                    dp[i][j] = grid[i-1][j-1] + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    // public int find(int[][] grid, int i, int j) {

    //     if (i == m - 1 && j == n - 1) {
    //         return grid[m-1][n-1];
    //     }
    //     if (dp[i][j] != -1) {
    //         return dp[i][j];
    //     }
    //     int right = Integer.MAX_VALUE;
    //     int bottom = Integer.MAX_VALUE;

    //     if (j < n - 1) {
    //         right = find(grid, i, j + 1);
    //     }
    //     if (i < m - 1) {
    //         bottom = find(grid, i + 1, j);
    //     }
    //     return dp[i][j] = grid[i][j] + Math.min(right, bottom);
    // }
}
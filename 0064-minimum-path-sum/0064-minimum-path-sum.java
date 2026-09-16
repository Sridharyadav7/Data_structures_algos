class Solution {
    int m;
    int n;
    int dp[][];

    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new int[m+1][n+1];
        for (int arr[]: dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = grid[i][j];
                }
                else {
                    int down = Integer.MAX_VALUE;
                    int right = Integer.MAX_VALUE;

                    if (i < m - 1) {
                        down = grid[i][j] + dp[i+1][j];
                    }
                    if (j < n - 1) {
                        right = grid[i][j] + dp[i][j+1];
                    }
                    dp[i][j] = Math.min(down, right);
                }
            }
        }
        return dp[0][0];
    }
    public int solve(int[][] grid, int i, int j) {
        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        if (i < m - 1) {
            down = grid[i][j] + solve(grid, i+1, j);
        }

        if (j < n - 1) {
            right = grid[i][j] + solve(grid, i, j+1);
        }

        return dp[i][j] = Math.min(right, down);
    }
}
class Solution {
    int m;
    int n;
    int dp[][][];

    public int cherryPickup(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        dp = new int[m+1][n+1][n+1];

        for (int mat[][]: dp) {
            for (int arr[]: mat) {
                Arrays.fill(arr, -1);
            }
        }

        return solve(grid, 0, 0, n-1);
    }
    public int solve(int[][] grid, int row, int col1, int col2) {
        if (row == m || col1 < 0 || col1 >= n || col2 < 0 || col2 >= n) {
            return 0;
        }

        int cherry = grid[row][col1];
        if (col1 != col2) {
            cherry += grid[row][col2];
        }

        if (dp[row][col1][col2] != -1) {
            return dp[row][col1][col2];
        }
        int ans = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                
                int newCol1 = i + col1;
                int newCol2 = j + col2;

                ans = Math.max(ans, solve(grid, row+1, newCol1, newCol2));
            }
        }

        return dp[row][col1][col2] = cherry + ans;
    }

}
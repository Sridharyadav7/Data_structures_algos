class Solution {
    int m;
    int n;
    int dp[][];
    
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new int[m+1][n+1];

        for (int arr[] : dp) {
            Arrays.fill(arr, -1);
        }
        return find(grid, 0, 0);
    }
    public int find(int[][] grid, int i, int j) {

        if (i == m - 1 && j == n - 1) {
            return grid[m-1][n-1];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int right = Integer.MAX_VALUE;
        int bottom = Integer.MAX_VALUE;

        if (j < n - 1) {
            right = find(grid, i, j + 1);
        }
        if (i < m - 1) {
            bottom = find(grid, i + 1, j);
        }
        return dp[i][j] = grid[i][j] + Math.min(right, bottom);
    }
}
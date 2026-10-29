class Solution {
    int m;
    int n;
    int dp[][];

    public int minPathCost(int[][] grid, int[][] moveCost) {
        m = grid.length;
        n = grid[0].length;
        int res = Integer.MAX_VALUE;
        dp = new int[m+1][n+1];

        for (int arr[]: dp) {
            Arrays.fill(arr, -1);
        }

        for (int col = 0; col < n; col++) {
            int val = solve(grid, moveCost, 0, col);
            res = Math.min(res, val);
        }

        return res;
    }
    public int solve(int[][] grid, int[][] moveCost, int i, int j) {
        if (i == m - 1) {
            return grid[i][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int val = Integer.MAX_VALUE;
        int currCell = grid[i][j];

        for (int col = 0; col < n; col++) {
            int temp = currCell + moveCost[currCell][col] + solve(grid, moveCost, i+1, col);
            val = Math.min(val, temp);
        }

        return dp[i][j] = val;
    }
}
class Solution {
    int n, m;
    int MOD = 1_000_000_007;
    long[][][] dp;

    public int maxProductPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        dp = new long[m][n][2];

        for (long[][] mat : dp) {
            for (long[] arr : mat) {
                arr[0] = Long.MIN_VALUE; // max
                arr[1] = Long.MAX_VALUE; // min
            }
        }

        long[] res = getProduct(grid, 0, 0);

        return res[0] < 0 ? -1 : (int)(res[0] % MOD);
    }

    public long[] getProduct(int[][] grid, int i, int j) {

        if (i == m - 1 && j == n - 1) {
            return new long[]{grid[i][j], grid[i][j]};
        }

        if (dp[i][j][0] != Long.MIN_VALUE ||
            dp[i][j][1] != Long.MAX_VALUE) {
            return dp[i][j];
        }

        long maxVal = Long.MIN_VALUE;
        long minVal = Long.MAX_VALUE;

        if (i + 1 < m) {
            long[] curr = getProduct(grid, i + 1, j);

            long a = grid[i][j] * curr[0];
            long b = grid[i][j] * curr[1];

            maxVal = Math.max(maxVal, Math.max(a, b));
            minVal = Math.min(minVal, Math.min(a, b));
        }

        if (j + 1 < n) {
            long[] curr = getProduct(grid, i, j + 1);

            long a = grid[i][j] * curr[0];
            long b = grid[i][j] * curr[1];

            maxVal = Math.max(maxVal, Math.max(a, b));
            minVal = Math.min(minVal, Math.min(a, b));
        }

        return dp[i][j] = new long[]{maxVal, minVal};
    }
}
class Solution {
    int rows;
    int cols;
    int dp[][] = new int[101][101];

    public int uniquePaths(int m, int n) {
        rows = m;
        cols = n;

        for(int arr[] : dp) {
            Arrays.fill(arr, -1);
        }

        return ways(0, 0);
    }
    public int ways(int row, int col) {
        if (row == rows - 1 && col == cols - 1) {
            return 1;
        }
        if (row == rows || col == cols) {
            return 0;
        }
        if(dp[row][col] != -1) {
            return dp[row][col];
        }

        int down = ways(row + 1, col);
        int right = ways(row, col + 1);

        return dp[row][col] = down + right;
    }
}
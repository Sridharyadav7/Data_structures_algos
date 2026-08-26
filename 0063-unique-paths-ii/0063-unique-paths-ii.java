class Solution {
    int rows;
    int cols;
    int dp[][] = new int[101][101];

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        rows = obstacleGrid.length;
        cols = obstacleGrid[0].length;

        for(int arr[] : dp) {
            Arrays.fill(arr, -1);
        }

        return ways(obstacleGrid, 0, 0);
    }
    public int ways(int[][] obstacleGrid, int row, int col) {
        if(row == rows - 1 && col == cols - 1 && obstacleGrid[row][col] == 0) {
            return 1;
        }
        if(row == rows || col == cols || obstacleGrid[row][col] == 1) {
            return 0;
        }
        if(dp[row][col] != -1) {
            return dp[row][col];
        }

        int down = ways(obstacleGrid, row + 1, col);
        int right = ways(obstacleGrid, row, col + 1);

        return dp[row][col] = down + right;
    }
}
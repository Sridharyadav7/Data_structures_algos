class Solution {
    int m;
    int n;
    int dp[][];

    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length;
        dp = new int[m+1][n+1];

        for (int arr[]: dp) {
            Arrays.fill(arr, -1);
        }

        return find(dungeon, 0, 0);
    }
    public int find(int[][] dungeon, int i, int j) {
        if (i == m || j == n) {
            return Integer.MAX_VALUE;
        }

        if (i == m - 1 && j == n - 1) {
            if (dungeon[i][j] > 0) {
                return 1;
            }
            return Math.abs(dungeon[i][j]) + 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = find(dungeon, i, j+1);
        int down = find(dungeon, i+1, j);

        int res = Math.min(right, down) - dungeon[i][j];
        dp[i][j] = res > 0 ? res : 1;
        return dp[i][j];
    }
}
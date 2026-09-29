class Solution {
    int m;
    int n;
    Boolean dp[][][];

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new Boolean[m+1][n+1][1000];

        return check(grid, 0, 0, 0);
    }
    public boolean check(char[][] grid, int i, int j, int cnt) {
        if (i == m || j == n) {
            return false;
        }

        if (grid[i][j] == '(') {
            cnt += 1;
        }
        else {
            cnt -= 1;
        }
        
        if (i == m-1 && j == n-1) {
            if (cnt == 0) {
                return true;
            }
            else {
                return false;
            }
        }

        if (cnt < 0) {
            return false;
        }

        if (dp[i][j][cnt] != null) {
            return dp[i][j][cnt];
        }

        return dp[i][j][cnt] = check(grid, i+1, j, cnt) || check(grid, i, j+1, cnt);
    }
}
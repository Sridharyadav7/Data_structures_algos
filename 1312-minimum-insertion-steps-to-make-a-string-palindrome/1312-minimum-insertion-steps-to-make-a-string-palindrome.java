class Solution {
    int dp[][];
    public int minInsertions(String s) {
        int n = s.length();
        dp = new int[n+1][n+1];
        // for (int arr[]: dp) {
        //     Arrays.fill(arr, Integer.MAX_VALUE);
        // }

        for(int l = 1; l <= n; l++) {
            for (int i = 0; i + l - 1 < n; i++) {
                int j = i + l - 1;
                if (i == j) {
                    dp[i][j] = 0;
                }
                else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1];
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
    public int solve(String s, int i, int j) {
        if (i > j) {
            return 0;
        }
        if(dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }
        int res = 0;
        if (s.charAt(i) == s.charAt(j)) {
            res = solve(s, i + 1, j - 1);
        }
        else {
            res = 1 + Math.min(solve(s, i + 1, j), solve(s, i, j - 1));
        }
        return dp[i][j] = res;
    }
}
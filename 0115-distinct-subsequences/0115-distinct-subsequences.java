class Solution {
    int dp[][];
    public int numDistinct(String s, String t) {
        int n = s.length();
        dp = new int[n+1][n+1];
        for (int arr[] : dp) {
            Arrays.fill(arr, -1);
        }
        // StringBuilder curr = new StringBuilder();
        return solve(n, s, 0, 0, t);
    }
    public int solve(int n, String s, int i, int j, String t) {
        if (j == t.length()) {  
            return 1;
        }
        if (i == n) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int pick = 0;
        int unpick = 0;

        if (s.charAt(i) == t.charAt(j)) {
            pick = solve(n, s, i+1, j+1, t);
        }
        unpick = solve(n, s, i+1, j, t);
        return  dp[i][j] = pick + unpick;
    }
}
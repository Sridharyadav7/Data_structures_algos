class Solution {
    int m;
    int n;
    int dp[][] = new int[501][501];

    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();

        for (int arr[] : dp) {
            Arrays.fill(arr, -1);
        }
        return solve(word1, word2, m, n);
    }
    public int solve(String s1, String s2, int i, int j) {
        if (i == 0 || j == 0) {
            return i + j;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int res = 0;

        if (s1.charAt(i-1) == s2.charAt(j-1)) {
            res = solve(s1, s2, i-1, j-1);
        }
        else {
            int insert = 1 + solve(s1, s2, i, j-1);
            int delete = 1 + solve(s1, s2, i-1, j);
            int replace = 1 + solve(s1, s2, i-1, j-1);

            res = Math.min(insert, Math.min(delete, replace));
        }
        
        return dp[i][j] = res;
    }
}
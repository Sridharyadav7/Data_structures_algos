class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        Boolean dp[][] = new Boolean[1001][1001];
        int cnt = 0;

        for (int l = 1; l <= n; l++) {
            for (int i = 0; i + l - 1 < n; i++) {
                int j = i + l - 1;
                if (i == j) {
                    dp[i][j] = true;
                } else if (j == i + 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                if (dp[i][j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
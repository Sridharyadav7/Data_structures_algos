class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        Boolean dp[][] = new Boolean[n+1][n+1];
        int maxlen = 0;
        int left = 0;
        int right = 0;

        for (int l = 1; l <= n; l++) {
            for (int i = 0; i + l - 1 < n; i++) {
                int j = i + l - 1;
                if (i == j) {
                    dp[i][j] = true;
                }
                else if (j == i + 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                }
                else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
                }
                if (dp[i][j] && j - i + 1 > maxlen) {
                    left = i;
                    right = j;
                    maxlen = j - i + 1;
                }
            }
        } 
        return s.substring(left, right + 1);
    }
}
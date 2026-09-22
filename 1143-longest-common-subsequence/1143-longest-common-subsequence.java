class Solution {
    int len1;
    int len2;
    int dp[][];

    public int longestCommonSubsequence(String text1, String text2) {
        len1 = text1.length();
        len2 = text2.length();
        dp = new int[len1+1][len2+1];

        // for (int arr[]: dp) {
        //     Arrays.fill(arr, -1);
        // }

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int pick = 0;
                int moveI = 0;
                int moveJ = 0;

                if (text1.charAt(i) == text2.charAt(j)) {
                    pick = 1 + dp[i+1][j+1];
                }
                moveI = dp[i+1][j];
                moveJ = dp[i][j+1];

                dp[i][j] = Math.max(pick, Math.max(moveI, moveJ));
            }
        }

        return dp[0][0];
    }
    public int solve(String s1, String s2, int i, int j) {
        if (i == len1 || j == len2) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int pick = 0;
        int moveI = 0;
        int moveJ = 0;

        if (s1.charAt(i) == s2.charAt(j)) {
            pick = 1 + solve(s1, s2, i+1, j+1);
        }
        moveI = solve(s1, s2, i+1, j);
        moveJ = solve(s1, s2, i, j+1);

        return dp[i][j] = Math.max(pick, Math.max(moveI, moveJ));
    }
}
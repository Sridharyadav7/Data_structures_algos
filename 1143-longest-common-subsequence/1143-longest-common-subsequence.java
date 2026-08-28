class Solution {
    int len1;
    int len2;
    int dp[][] = new int[1001][1001];

    public int longestCommonSubsequence(String text1, String text2) {
        len1 = text1.length();
        len2 = text2.length();

        for (int arr[] : dp) {
            Arrays.fill(arr, -1);
        }

        return solve(text1, text2, 0, 0);
    }
    public int solve(String text1, String text2, int ind1, int ind2) {
        if (ind1 == len1 || ind2 == len2) {
            return 0;
        }
        if (dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }

        int ans = 0;
        if(text1.charAt(ind1) == text2.charAt(ind2)) {
            ans = 1 + solve(text1, text2, ind1 + 1, ind2 + 1);
        }
        else {
            ans = Math.max(solve(text1, text2, ind1, ind2 + 1), solve(text1, text2, ind1 + 1, ind2));
        }
        return dp[ind1][ind2] = ans;
    }
}
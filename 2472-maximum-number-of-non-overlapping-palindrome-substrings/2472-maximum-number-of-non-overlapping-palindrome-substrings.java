class Solution {
    boolean palindrome[][];
    int n;
    int K;
    public int maxPalindromes(String s, int k) {
        n = s.length();
        palindrome = new boolean[n][n];
        K = k;

        for (int l = 1; l <= n; l++) {
            for (int i = 0; i + l - 1 < n; i++) {
                int j = i + l - 1;
                if (i == j) {
                    palindrome[i][j] = true;
                }
                else if (i + 1 == j) {
                    palindrome[i][j] = s.charAt(i) == s.charAt(j);
                }
                else {
                    palindrome[i][j] = (s.charAt(i) == s.charAt(j)) && palindrome[i+1][j-1];
                }
            }
        } 

        int dp[][] = new int[n+1][n+1];
        for (int arr[] : dp) {
            Arrays.fill(arr, -1);
        }
        return solve(s, 0, k-1, dp);
    }
    public int solve(String s, int i, int j, int dp[][]) {
        if (i >= n || j >= n) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (palindrome[i][j]) {
            int take = 1 + solve(s, j+1, j+K, dp);
            int skip = solve(s, i, j+1, dp);
            int slide = solve(s, i+1, j+1, dp);

            return dp[i][j] = Math.max(take, Math.max(skip, slide));
        }
        int skip = solve(s, i, j+1, dp);
        int slide = solve(s, i+1, j+1, dp);

        return dp[i][j] = Math.max(skip, slide);
    }
}
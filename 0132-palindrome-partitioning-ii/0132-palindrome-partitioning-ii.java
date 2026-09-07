class Solution {
    int ans;
    public int minCut(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n+1][n+1];

        for(int l = 1; l <= n; l++) {
            for(int i = 0; i + l - 1 < n; i++) {
                int j = i + l - 1;
                if(i == j) {
                    dp[i][j] = true;
                }
                else if(j == i + 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }
                else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
                }
            }
        }
        int cuts[] = new int[n];
        Arrays.fill(cuts, Integer.MAX_VALUE);
        cuts[0] = 0;

        for (int i = 1; i < n; i++) {
            if (dp[0][i]) {
                cuts[i] = 0;
            }
            for (int k = 0; k < i; k++) {
                if (dp[k + 1][i]) {
                    cuts[i] = Math.min(cuts[i], cuts[k] + 1);
                }
            }
        }
        return cuts[n-1];
    }
    
}
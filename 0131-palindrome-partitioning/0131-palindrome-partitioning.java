class Solution {
    public List<List<String>> partition(String s) {
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
        List<List<String>> res = new ArrayList<>();
        List<String> currPartition = new ArrayList<>();
        solve(s, 0, currPartition, res, dp);
        return res;
    }
    public void solve(String s, int i, List<String> currPartition, List<List<String>> res, boolean dp[][]) {
        if(i == s.length()) {
            res.add(new ArrayList<>(currPartition));
            return;
        }
        for(int j = i; j < s.length(); j++) {
            if(dp[i][j]) {
                currPartition.add(s.substring(i, j+1));
                solve(s, j+1, currPartition, res, dp);
                currPartition.remove(currPartition.size()-1);
            }
        }
        return;
    }
}
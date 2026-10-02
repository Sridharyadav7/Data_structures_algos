class Solution {
    int m;
    int n;
    int ans;
    int dp[][];

    public int findLength(int[] nums1, int[] nums2) {
        m = nums1.length;
        n = nums2.length;
        dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    continue;
                }
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    ans = Math.max(ans, dp[i][j]);
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }
    
        return ans;
    }
    
}
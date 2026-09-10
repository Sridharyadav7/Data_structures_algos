class Solution {
    public int countHousePlacements(int n) {
        int MOD = 1_000_000_007;
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % MOD;
        }

        return (int)((long)dp[n] * dp[n] % MOD);
    }
}
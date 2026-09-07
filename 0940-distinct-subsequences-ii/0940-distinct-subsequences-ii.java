class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length();
        int MOD = 1_000_000_007;

        int[] dp = new int[n + 1];
        int[] prevIndex = new int[26];

        Arrays.fill(prevIndex, -1);
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            int total = (dp[i-1] * 2) % MOD;

            if (prevIndex[c - 'a'] != -1) {
                total = (total - dp[prevIndex[c - 'a'] - 1]) % MOD;
            }
            dp[i] = total % MOD;
            prevIndex[c - 'a'] = i;
        }

        return (dp[n] - 1 + MOD) % MOD;
    }
}
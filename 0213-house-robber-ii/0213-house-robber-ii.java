class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int dp[] = new int[n+2];

        for (int i = 2; i < n + 1; i++) {
            dp[i] = Math.max(nums[i-2] + dp[i-2], dp[i-1]);
        }
        int pickFirst = dp[n];
        Arrays.fill(dp, 0);

        for (int i = 3; i <= n + 1; i++) {
            dp[i] = Math.max(nums[i-2] + dp[i-2], dp[i-1]);
        }

        return Math.max(pickFirst, dp[n+1]);
    }
}
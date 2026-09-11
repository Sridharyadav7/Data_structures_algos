class Solution {
    int n;
    // int dp[][];

    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        int dp[] = new int[n+1];
        int ans = 1;
        Arrays.fill(dp, 1);

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    dp[j] = Math.max(dp[j], 1 + dp[i]);
                    ans = Math.max(ans, dp[j]);
                }
            }
        }
        return ans;
    }
    // public int find(int nums[], int i, int prevInd) {
    //     if (i == n) {
    //         return 0;
    //     }

    //     if (dp[i][prevInd + 1] != -1) {
    //         return dp[i][prevInd + 1];
    //     }

    //     int pick = 0;
    //     if (prevInd == -1 || nums[i] > nums[prevInd]) {
    //         pick = 1 + find(nums, i+1, i);
    //     }

    //     int unpick = find(nums, i+1, prevInd);
    //     return dp[i][prevInd + 1] = Math.max(pick, unpick);
    // }
}
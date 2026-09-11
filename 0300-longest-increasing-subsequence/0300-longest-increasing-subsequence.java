class Solution {
    int n;
    int dp[][];

    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        dp = new int[n+1][n+1];
        for (int arr[]: dp) {
            Arrays.fill(arr, -1);
        }
        return find(nums, 0, -1);
    }
    public int find(int nums[], int i, int prevInd) {
        if (i == n) {
            return 0;
        }

        if (dp[i][prevInd + 1] != -1) {
            return dp[i][prevInd + 1];
        }

        int pick = 0;
        if (prevInd == -1 || nums[i] > nums[prevInd]) {
            pick = 1 + find(nums, i+1, i);
        }

        int unpick = find(nums, i+1, prevInd);
        return dp[i][prevInd + 1] = Math.max(pick, unpick);
    }
}
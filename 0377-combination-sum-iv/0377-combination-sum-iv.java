class Solution {
    int n;
    int dp[][];

    public int combinationSum4(int[] nums, int target) {
        n = nums.length;
        dp = new int[n+1][target+1];
        
        for (int arr[]: dp) {
            Arrays.fill(arr, -1);
        }

        return solve(nums, target, 0, 0);
    }
    public int solve(int[] nums, int target, int i, int sum) {
        if (sum > target || i == n) {
            return 0;
        }
        if (sum == target) {
            return 1;
        }

        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }
        int pick = solve(nums, target, 0, sum + nums[i]);
        int skip = solve(nums, target, i+1, sum);

        return dp[i][sum] = pick + skip;
    }
}
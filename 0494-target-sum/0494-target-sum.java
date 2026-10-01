class Solution {
    int n;
    int OFFSET = 1000;
    Integer dp[][];

    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;
        dp = new Integer[n+1][2001];
        return find(nums, target, 0, 0); 
    }
    public int find(int nums[], int target, int i, int sum) {
        if (i == n) {
            if (sum == target) {
                return 1;
            }
            else {
                return 0;
            }
        }
        if (dp[i][sum+OFFSET] != null) {
            return dp[i][sum+OFFSET];
        }
        int add = find(nums, target, i+1, sum + nums[i]);
        int subtract = find(nums, target, i+1, sum - nums[i]);

        return dp[i][sum+OFFSET] = add + subtract;
    }
}
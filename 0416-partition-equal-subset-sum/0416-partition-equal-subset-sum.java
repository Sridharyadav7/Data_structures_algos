class Solution {
    int target = 0;
    Boolean dp[][];

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            target += nums[i];
        }
        if (target % 2 == 1) {
            return false;
        }
        target /= 2;
        dp = new Boolean[n+1][target+1];
        return check(n, nums, 0, 0);
    }
    public boolean check(int n, int nums[], int ind, int sum) {
        if (sum > target) {
            return false;
        }
        
        if (ind == n) {
            return sum == target ? true : false;
        }

        if (dp[ind][sum] != null) {
            return dp[ind][sum];
        }
        boolean pick = check(n, nums, ind+1, sum + nums[ind]);
        boolean unpick = check(n, nums, ind+1, sum);
        
        return dp[ind][sum] = pick || unpick;
    }
}
class Solution {
    int ans = 0;

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        recurse(n, nums, 0, 0, target);
        return ans;
    }
    public void recurse(int n, int nums[], int ind, int sum, int target) {
        if(ind == n) {
            if(sum == target) {
                ans += 1;
            }
            return;
        }
        recurse(n, nums, ind + 1, sum + nums[ind], target);
        recurse(n, nums, ind + 1, sum - nums[ind], target);
    }
}
class Solution {
    int n;

    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;
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

        int add = find(nums, target, i+1, sum + nums[i]);
        int subtract = find(nums, target, i+1, sum - nums[i]);

        return add + subtract;
    }
}
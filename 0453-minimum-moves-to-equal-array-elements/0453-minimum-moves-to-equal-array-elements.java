class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        if (n == 1 || isEqual(nums, n)) {
            return 0;
        }

        Arrays.sort(nums);
        int ans = 0;

        for (int i = n - 1; i >= 1; i--) {
            ans += nums[i] - nums[0];
        }

        return ans;
    }
    public boolean isEqual(int nums[], int n) {
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] != nums[i+1]) {
                return false;
            }
        }
        return true;
    }
}
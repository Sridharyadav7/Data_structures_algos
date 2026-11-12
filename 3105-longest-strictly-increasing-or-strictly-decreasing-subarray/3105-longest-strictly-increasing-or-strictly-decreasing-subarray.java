class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans = 1;
        int len = 1;
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i-1]) {
                len++;
            }
            else {
                len = 1;
            }
            ans = Math.max(ans, len);
        }

        len = 1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > nums[i+1]) {
                len++;
            }
            else {
                len = 1;
            }
            ans = Math.max(ans, len);
        }

        return ans;
    }
}
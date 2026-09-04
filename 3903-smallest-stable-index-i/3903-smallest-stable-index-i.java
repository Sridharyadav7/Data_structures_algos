class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int maxLeft[] = new int[n];
        int prevMax = 0;

        for(int i = 0; i < n; i++) {
            maxLeft[i] = Math.max(prevMax, nums[i]);
            prevMax = Math.max(prevMax, nums[i]);
        }

        int minLeft = Integer.MAX_VALUE;
        int ans = -1;

        for (int i = n - 1; i >= 0; i--) {
            minLeft = Math.min(minLeft, nums[i]);
            int val = maxLeft[i] - minLeft;

            if (val <= k) {
                ans = i;
            }
        }

        return ans;
    }
}
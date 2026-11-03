class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        Arrays.sort(nums);
        int target = nums[n-1];
        int res = 0;

        for (int i = 0; i < n - 1; i++) {
            res += Math.abs(nums[i] - target);
        }

        return res;
    }
}
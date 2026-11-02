class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        Arrays.sort(nums);
        int ind = n / 2;
        int res = 0;

        for (int i = 0; i < n; i++) {
            res += Math.abs(nums[i] - nums[ind]);
        }

        return res;
    }
}
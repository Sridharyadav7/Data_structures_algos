class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum < x) {
            return -1;
        }

        long target = sum - x;

        if (target == 0) {
            return n;
        }
        
        int l = 0;
        int maxlen = 0;
        long currSum = 0;

        for (int r = 0; r < n; r++) {
            currSum += nums[r];

            while (currSum > target) {
                currSum -= nums[l];
                l++;
            }

            if (currSum == target) {
                maxlen = Math.max(maxlen, r - l + 1);
            }
        }

        return maxlen == 0 ? -1 : n - maxlen;
    }
}
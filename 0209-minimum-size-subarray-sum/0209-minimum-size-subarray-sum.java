class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        long sum = 0L;
        int minlen = Integer.MAX_VALUE;
        int left = 0;

        for(int right = 0; right < n; right++) {
            sum += nums[right];

            if(sum >= target) {
                minlen = Math.min(minlen, right - left + 1);
            }

            while(sum > target) {
                sum -= nums[left];
                left++;

                if(sum >= target) {
                    minlen = Math.min(minlen, right - left + 1);
                }
            }
        }
        return minlen == Integer.MAX_VALUE ? 0 : minlen;
    }
}
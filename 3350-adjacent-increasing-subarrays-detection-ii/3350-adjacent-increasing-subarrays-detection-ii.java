class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int ans = 1;
        int len = 1;
        int prevlen = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i-1)) {
                len++;
            }
            else {
                int max1 = len / 2;
                int max2 = Integer.MIN_VALUE;
                if (prevlen != Integer.MAX_VALUE) {
                    max2 = Math.min(prevlen, len);
                }
                ans = Math.max(ans, Math.max(max1, max2));
                prevlen = len;
                len = 1;
            }
        }

        int max1 = len / 2;
        int max2 = Integer.MIN_VALUE;
        if (prevlen != Integer.MAX_VALUE) {
            max2 = Math.min(prevlen, len);
        }
        ans = Math.max(ans, Math.max(max1, max2));
        
        return ans;
    }
}
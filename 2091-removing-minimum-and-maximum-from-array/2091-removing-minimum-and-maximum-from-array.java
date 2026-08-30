class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;
        if(n == 2) return 2;

        int left = 0;
        int right = 0;

        for(int i = 1; i < n; i++) {
            if(nums[i] < nums[left]) {
                left = i;
            }
            if(nums[i] > nums[right]) {
                right = i;
            }
        }

        if (right < left) {
            int temp = right;
            right = left;
            left = temp;
        }

        int minFront = left + 1;
        minFront += right - left;

        int minBack = n - right;
        minBack += right - left;

        int bothSides = Math.min(left, right) + 1;
        bothSides += Math.min(n - right, n - left);

        int ans = Math.min(bothSides, Math.min(minFront, minBack));
        return ans;
    }
}
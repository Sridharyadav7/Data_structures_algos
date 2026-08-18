class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int dp1[] = new int[n];
        int dp2[] = new int[n+1];
        
        dp1[0] = 0;
        dp1[1] = nums[0]; 

        for (int i = 2; i < n; i++) {

            int pick = nums[i-1] + dp1[i-2];
            int unpick = dp1[i-1];

            dp1[i] = Math.max(pick, unpick);
        }

        dp2[0] = 0;
        dp2[1] = 0;

        for(int i = 2; i <= n; i++) {

            int pick = nums[i-1] + dp2[i-2];
            int unpick = dp2[i-1];

            dp2[i] = Math.max(pick, unpick);
        }

        return Math.max(dp1[n-1], dp2[n]);
    }
}
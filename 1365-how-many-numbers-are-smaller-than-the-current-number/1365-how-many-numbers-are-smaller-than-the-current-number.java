class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int map[] = new int[101];
        for(int val : nums) {
            map[val]++;
        }
        for(int i = 1; i < 101; i++) {
            map[i] += map[i-1];
        }
        int n = nums.length;
        int ans[] = new int[n];
        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) ans[i] = 0;
            else ans[i] = map[nums[i]-1];
        }
        return ans;
    }
}
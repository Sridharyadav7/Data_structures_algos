class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int sum = nums[0];

        for(int i = 1; i < n; i++) {
            if(nums[i] == nums[i-1] + 1) {
                sum += nums[i];
            }
            else break;
        }

        for(int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        int ans = sum;
        while(set.contains(ans)) {
            ans++;
        }
        return ans;
    }
}
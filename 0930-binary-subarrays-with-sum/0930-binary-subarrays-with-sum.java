class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;

        for(int i = 0; i < n; i++) {
            sum += nums[i];
            int target = sum - goal;

            if(map.containsKey(target)) {
                ans += map.get(target);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MIN_VALUE;
        int maxFreq = 0;
        int ele = 0;
        int left = 0;
        for(int right = 0; right < n; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            maxFreq = map.get(nums[right]);
            ele = nums[right];

            if(maxFreq <= k) ans = Math.max(ans, right - left + 1);
            
            while(map.get(ele) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }
        }
        return ans;
    }
}
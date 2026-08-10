class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Long, Integer> map = new HashMap<>();
        int cnt = 0;
        long sum = 0;
        map.put(sum, 1);

        for(int i = 0; i < n; i++) {
            sum += nums[i];
            long target = sum - k;

            if(map.containsKey(target)) {
                cnt += map.get(target);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }    
        return cnt;
    }
}
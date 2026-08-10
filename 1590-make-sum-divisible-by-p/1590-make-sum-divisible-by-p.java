class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long sum = 0;

        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }

        int rem = (int) (sum % p);
        if(rem == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        long currSum = 0;
        int minlen = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            currSum += nums[i];
            int currRem = (int) (currSum % p);
            int target = (currRem - rem + p) % p;

            if(map.containsKey(target)) {
                minlen = Math.min(minlen, i - map.get(target));
            }

            map.put(currRem, i);
        }

        if(minlen == Integer.MAX_VALUE || minlen == n) {
            return -1;
        }
        return minlen;
    }
}
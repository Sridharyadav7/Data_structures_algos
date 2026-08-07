class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        map.put(0, 1);
        int sum = 0;

        // If currSum % k == x and there already exists a previous subarray with
        // same remainder, then (currSum - prevSum) is a subarray such that its remainder
        // with k is 0;
        // We increment the number of times we encountered the remainder to count the subarrays

        for(int i = 0; i < n; i++) {
            sum += nums[i];
            int rem = sum % k;

            if(rem < 0) {
                rem += k;
            }
            if(map.containsKey(rem)) {
                cnt += map.get(rem);
                map.put(rem, map.get(rem) + 1);
            }
            else {
                map.put(rem, 1);
            }
        }

        return cnt;
    }
}
class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int curr = nums[0];
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] == curr) {
                cnt++;
            }
            else {
                list.add(curr);
                map.put(curr, cnt * curr);
                curr = nums[i];
                cnt = 1;
            }
        }
        list.add(curr);
        map.put(curr, cnt * curr);
        
        int len = list.size();
        int dp[] = new int[len + 1];
        dp[0] = 0;
        dp[1] = map.get(list.get(0));

        for(int i = 2; i <= len; i++) {
            if(list.get(i-1) == list.get(i-2) + 1) {
                dp[i] = Math.max(dp[i-2] + map.get(list.get(i-1)), dp[i-1]);
            }
            else {
                dp[i] = dp[i-1] + map.get(list.get(i-1));
            }
        }
        return dp[len];
    }
}
class Solution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        int curr = nums[0];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] == curr) {
                cnt++;
            }
            else {
                map.put(curr, cnt * curr);
                list.add(curr);
                curr = nums[i];
                cnt = 1;
            }
        }
        map.put(curr, cnt * curr);
        list.add(curr);

        int len = list.size();
        int dp[] = new int[len + 2];
        dp[2] = map.get(nums[0]);

        for (int i = 3; i < len + 2; i++) {
            curr = list.get(i-2);
            int prev = list.get(i-3);

            if (curr > prev + 1) {
                dp[i] = map.get(curr) + dp[i-1];
            }
            else {
                dp[i] = Math.max(map.get(curr) + dp[i-2], dp[i-1]);
            }
        }
        return dp[len+1];
    }
}
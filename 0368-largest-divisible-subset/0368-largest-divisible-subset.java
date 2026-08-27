class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int[] dp = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int maxLen = 1;
        int maxIndex = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[i] % nums[j] == 0 &&
                    dp[j] + 1 > dp[i]) {

                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIndex = i;
            }
        }

        List<Integer> res = new ArrayList<>();

        while (parent[maxIndex] != maxIndex) {
            res.add(nums[maxIndex]);
            maxIndex = parent[maxIndex];
        }

        res.add(nums[maxIndex]);

        Collections.reverse(res);

        return res;
    }
}
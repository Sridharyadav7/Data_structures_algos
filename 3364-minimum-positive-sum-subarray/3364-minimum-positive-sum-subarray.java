class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int minSum = Integer.MAX_VALUE;
        int prefix[] = new int[n];
        prefix[0] = nums.get(0);

        for (int i = 1; i < n; i++) {
            prefix[i] = nums.get(i) + prefix[i-1];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + l - 1; j < i + r && j < n; j++) {
                int val = i > 0 ? prefix[i-1] : 0;
                int sum = prefix[j] - val;
                if (sum > 0 && sum < minSum) {
                    minSum = sum;
                }
            }
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}
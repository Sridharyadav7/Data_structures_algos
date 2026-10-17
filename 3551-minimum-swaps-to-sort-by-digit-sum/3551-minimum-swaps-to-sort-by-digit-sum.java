class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int pairs[][] = new int[n][2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
            pairs[i][0] = nums[i];
            pairs[i][1] = getSum(nums[i]);
        }
        
        Arrays.sort(pairs, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int swaps = 0;
        boolean vis[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (vis[map.get(pairs[i][0])]) {
                continue;
            }

            int curr = map.get(pairs[i][0]);
            int cycleLen = 0;

            while (!vis[curr]) {
                vis[curr] = true;
                curr = map.get(pairs[curr][0]);
                cycleLen += 1;
            }

            swaps += cycleLen - 1;
        }

        return swaps;
    }

    public int getSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}
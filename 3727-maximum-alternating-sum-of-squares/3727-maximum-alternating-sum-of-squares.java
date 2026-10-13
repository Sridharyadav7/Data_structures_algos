class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int val = nums[i];
            if (val < 0) {
                val *= -1;
            }
            pq.add(val);
        }

        for (int i = 0; i < n; i += 2) {
            long val = (int) pq.poll();
            val = val * val;
            ans += val;
        }

        for (int i = 1; i < n; i += 2) {
            long val = (int) pq.poll();
            val = val * val;
            ans -= val;
        }

        return ans;
    }
}
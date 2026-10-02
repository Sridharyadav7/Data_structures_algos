class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long sum[] = new long[n];
        int ans = 0;
        long maxSum = 0;

        for (int i = 0; i < n; i++) {
            sum[edges[i]] += i;
        }

        for(int i = 0; i < n; i++) {
            if (sum[i] > maxSum) {
                maxSum = sum[i];
                ans = i;
            }
        }

        return ans;
    }
}
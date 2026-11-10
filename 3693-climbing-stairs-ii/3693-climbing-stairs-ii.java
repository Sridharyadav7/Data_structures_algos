class Solution {
    int N;
    int dp[];

    public int climbStairs(int n, int[] costs) {
        N = n;
        dp = new int[N+1];
        Arrays.fill(dp, -1);
        return solve(-1, costs);
    }
    public int solve(int i, int costs[]) {
        if (i >= N) {
            return Integer.MAX_VALUE;
        }

        if (i == N - 1) {
            return 0;
        }

        if (dp[i+1] != -1) {
            return dp[i+1];
        }

        int first = Integer.MAX_VALUE;
        if (i < N - 1) {
            int next = solve(i+1, costs);
            if (next != Integer.MAX_VALUE) {
                first = costs[i+1] + 1 + next;
            }
        }
        int second = Integer.MAX_VALUE;
        if (i < N - 2) {
            int next = solve(i+2, costs);
            if (next != Integer.MAX_VALUE) {
                second = costs[i+2] + 4 + next;
            }
        }
        int third = Integer.MAX_VALUE;
        if (i < N - 3) {
            int next = solve(i+3, costs);
            if (next != Integer.MAX_VALUE) {
                third = costs[i+3] + 9 + next;
            }
        }

        return dp[i+1] = Math.min(first, Math.min(second, third));
    }
}
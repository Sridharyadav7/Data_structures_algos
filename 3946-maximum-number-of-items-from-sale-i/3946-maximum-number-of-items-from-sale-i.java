class Solution {
    int N;
    int BUDGET;
    int[][][] dp;

    public int maximumSaleItems(int[][] items, int budget) {
        N = items.length;
        BUDGET = budget;
        int dividends[] = new int[N];
        dp = new int[N + 1][budget + 1][2];

        for (int mat[][]: dp) {
            for (int arr[]: mat) {
                Arrays.fill(arr, -1);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    dividends[i]++;
                }
            }
        }

        return solve(items, dividends, 0, 0, 0);
    }
    public int solve(int[][] items, int dividends[], int i, int spent, int alreadyPicked) {
        if (i == N) {
            return 0;
        }
        if (spent == BUDGET) {
            return 0;
        }

        if (dp[i][spent][alreadyPicked] != -1) {
            return dp[i][spent][alreadyPicked];
        }

        int pick = Integer.MIN_VALUE;
        int pickAndStay = Integer.MIN_VALUE;
        int skip = Integer.MIN_VALUE;

        if (items[i][1] <= BUDGET - spent) {
            int val = alreadyPicked  == 1 ? 0 : dividends[i];
            pick = 1 + val + solve(items, dividends, i+1, spent + items[i][1], 0);
            pickAndStay = 1 + val + solve(items, dividends, i, spent + items[i][1], 1);
        }

        skip = solve(items, dividends, i+1, spent, 0);

        return dp[i][spent][alreadyPicked] = Math.max(pick, Math.max(pickAndStay, skip));
    }
}
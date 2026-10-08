class Solution {
    int n;
    int ans;
    int dp[][];

    public int coinChange(int[] coins, int amount) {
        n = coins.length;
        ans = Integer.MAX_VALUE;
        Arrays.sort(coins);
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int temp = coins[i];
            coins[i] = coins[j];
            coins[j] = temp;
        }
        dp = new int[n+1][10001];
        for (int arr[]: dp) {
            Arrays.fill(arr, -1);
        }
        ans = find(coins, amount, 0, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public int find(int coins[], int amount, int i, int sum) {
        if (sum > amount || i == n) {
            return Integer.MAX_VALUE;
        }
        if (sum == amount) {
           return 0; 
        }

        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }
        int pickResult = find(coins, amount, i, sum + coins[i]);
        int pick = 0;
        if (pickResult == Integer.MAX_VALUE) {
            pick = Integer.MAX_VALUE;
        }
        else {
            pick = 1 + pickResult;
        }

        int skip = find(coins, amount, i+1, sum);
        return dp[i][sum] = Math.min(pick, skip);
    }
}
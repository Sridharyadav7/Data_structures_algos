class Solution {
    int n;
    int dp[][];

    public int change(int amount, int[] coins) {
        n = coins.length;
        dp = new int[n+1][amount+1];

        for (int arr[]: dp) {
            Arrays.fill(arr, -1);
        }
        return find(coins, amount, 0, 0);
    }
    public int find(int[] coins, int amount, int i, int sum) {
        if (sum == amount) {
            return 1;
        }
        if (sum > amount || i == n) {
            return 0;
        }

        if (dp[i][sum] != -1) {
            return dp[i][sum]; 
        }

        int pick = find(coins, amount, i, sum + coins[i]);
        int skip = find(coins, amount, i+1, sum);

        return dp[i][sum] = pick + skip;
    }
}
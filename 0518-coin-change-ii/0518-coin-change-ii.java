class Solution {
    int dp[][] = new int[301][5001];

    public int change(int amount, int[] coins) {
        int n = coins.length;

        for (int arr[] : dp) {
            Arrays.fill(arr, -1);
        }
        return find(n, coins, amount, 0, 0);
    }
    public int find(int n, int coins[], int amount, int ind, int sum) {
        if (ind == n && sum == amount) {
            return 1;
        }
        else if (ind == n || sum > amount) {
            return 0;
        }
        if (dp[ind][sum] != -1) {
            return dp[ind][sum];
        }
        int pick = find(n, coins, amount, ind, sum + coins[ind]);
        int unpick = find(n, coins, amount, ind + 1, sum);

        return dp[ind][sum] = pick + unpick;
    }
}
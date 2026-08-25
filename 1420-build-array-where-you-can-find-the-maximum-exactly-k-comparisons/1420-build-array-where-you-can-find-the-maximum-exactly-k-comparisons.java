class Solution {
    int N;
    int M;
    int K;
    int MOD = 1_000_000_007;
    int dp[][][] = new int[51][51][101];

    public int numOfArrays(int n, int m, int k) {
        N = n; 
        M = m;
        K = k;

        for(int nums[][] : dp) {
            for(int arr[] : nums) {
                Arrays.fill(arr, -1);
            }
        }

        return solve(0, 0, 0);
    }   

    public int solve(int ind, int searchCost, int maxSoFar) {
        if (ind  == N) {
            if(searchCost == K) {
                return 1;
            }
            return 0;
        }

        if(dp[ind][searchCost][maxSoFar] != -1) {
            return dp[ind][searchCost][maxSoFar];
        }

        int result = 0;

        for(int i = 1; i <= M; i++) {
            if(i > maxSoFar) {
                result = (result + solve(ind + 1, searchCost + 1, i)) % MOD;
            }
            else {
                result = (result + solve(ind + 1, searchCost, maxSoFar)) % MOD;
            }
        }
        return dp[ind][searchCost][maxSoFar] = result % MOD;
    }
}
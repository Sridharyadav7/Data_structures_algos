class Solution {
    int M;
    int N;
    int dp[][];

    public int uniquePaths(int m, int n) {
        M = m;
        N = n;
        dp = new int[M+1][N+1];

        // for (int arr[]: dp) {
        //     Arrays.fill(arr, -1);
        // }

        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (i == M - 1 && j == N - 1) {
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = dp[i][j+1] + dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }
    public int find(int i, int j) {
        if (i >= M || j >= N) {
            return 0;
        }

        if (i == M - 1 && j == N - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = find(i, j+1);
        int down = find(i+1, j);

        return dp[i][j] = right + down;
    }
}
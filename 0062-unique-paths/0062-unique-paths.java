class Solution {
    int M;
    int N;
    int dp[][];
    
    public int uniquePaths(int m, int n) {
        M = m;
        N = n;
        dp = new int[M+1][N+1];

        for (int arr[]: dp) {
            Arrays.fill(arr, -1);
        }
        return find(0, 0);
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
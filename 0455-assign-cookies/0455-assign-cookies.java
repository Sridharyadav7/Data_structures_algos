class Solution {
    int n;
    int m;
    int dp[][];

    public int findContentChildren(int[] g, int[] s) {
        n = g.length;
        m = s.length;
        // dp = new int[n+1][m+1];
        Arrays.sort(g);
        Arrays.sort(s);

        // for (int arr[]: dp) {
        //     Arrays.fill(arr, -1);
        // }

        int ans = 0;
        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            if (s[j] >= g[i]) {
                ans++;
                i++;
                j++;
            }
            else {
                j++;
            }
        }
        return ans;
    }
    public int solve(int g[], int s[], int i, int j) {
        if (i == n || j == m) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int take = 0;
        int skip = 0;

        if (s[j] >= g[i]) {
            take = 1 + solve(g, s, i+1, j+1);
            skip = solve(g, s, i+1, j);
        }
        else {
            skip = solve(g, s, i, j+1);
        }

        return dp[i][j] = Math.max(take, skip);
    }
}
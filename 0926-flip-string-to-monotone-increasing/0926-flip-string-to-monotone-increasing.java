class Solution {
    int N;
    int dp[][];

    public int minFlipsMonoIncr(String s) {
        N = s.length();
        dp = new int[N][3];
        for (int arr[]: dp) {
            Arrays.fill(arr, -1);
        }
        return find(s, 0, -1);
    }
    public int find(String s, int i, int prev) {
        if (i == N) {
            return 0;
        }

        if (dp[i][prev+1] != -1) {
            return dp[i][prev+1];
        }
        int flip = Integer.MAX_VALUE;
        int skip = Integer.MAX_VALUE;

        if (s.charAt(i) == '0') {
            if (prev != -1 && prev == 1) {
                flip = 1 + find(s, i+1, 1);
            }
            else {
                flip = 1 + find(s, i+1, 1);
                skip = find(s, i+1, 0);
            }
        }
        else {
            if (prev != 1) {
                flip = 1 + find(s, i+1, 0);
                skip = find(s, i+1, 1);
            }
            else {
                skip = find(s, i+1, 1);
            }
        }

        return dp[i][prev+1] = Math.min(flip, skip);
    }
}
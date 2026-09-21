class Solution {
    int n;
    int dp2[][];
    int dp3[][];

    public int maxCollectedFruits(int[][] fruits) {
        n = fruits.length;
        int ans = 0;
        dp2 = new int[n+1][n+1];
        for (int arr[] : dp2) {
            Arrays.fill(arr, -1);
        }

        dp3 = new int[n+1][n+1];
        for (int arr[] : dp3) {
            Arrays.fill(arr, -1);
        }

        ans = child1(fruits);
        ans += child2(fruits, 0, n-1);
        ans += child3(fruits, n-1, 0);

        return ans;
    }

    public int child1(int[][] fruits) {
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            cnt += fruits[i][i];
        }

        return cnt;
    }
    public int child2(int[][] fruits, int i, int j) {

        if (i >= n || j < 0 || j >= n) {
            return 0;
        }

        if (i == j || i > j) {
            return 0;
        }

        if (i == n-1 && j == n-1) {
            return 0;
        }

        if (dp2[i][j] != -1) {
            return dp2[i][j];
        }

        int bottomLeft = fruits[i][j] + child2(fruits, i+1, j-1);
        int bottom = fruits[i][j] + child2(fruits, i+1, j);
        int bottomRight = fruits[i][j] + child2(fruits, i+1, j+1);

        return dp2[i][j] = Math.max(bottomLeft, Math.max(bottom, bottomRight));
    }

    public int child3(int[][] fruits, int i, int j) {

        if (i < 0 || i >= n || j < 0 || j >= n) {
            return 0;
        }

        if (i == j || i < j) {
            return 0;
        }

        if (i == n-1 && j == n-1) {
            return 0;
        }

        if (dp3[i][j] != -1) {
            return dp3[i][j];
        }

        int topLeft = fruits[i][j] + child3(fruits, i-1, j+1);
        int right = fruits[i][j] + child3(fruits, i, j+1);
        int bottomRight = fruits[i][j] + child3(fruits, i+1, j+1);

        return dp3[i][j] = Math.max(topLeft, Math.max(bottomRight, right));
    }
}
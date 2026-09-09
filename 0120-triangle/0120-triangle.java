class Solution {
    int[][] dp;

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        dp = new int[n][n];

        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        return find(triangle, 0, 0);
    }

    public int find(List<List<Integer>> triangle, int row, int ind) {

        // Last row
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(ind);
        }

        // Already calculated
        if (dp[row][ind] != Integer.MAX_VALUE) {
            return dp[row][ind];
        }

        int current = triangle.get(row).get(ind);

        int first = current + find(triangle, row + 1, ind);

        int second = current + find(triangle, row + 1, ind + 1);

        return dp[row][ind] = Math.min(first, second);
    }
}
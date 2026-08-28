class Solution {
    int sum = 0;
    int dp[][] = new int[201][201];

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int sum =  triangle.get(0).get(0);

        for (int arr[] : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        if (n == 1) {
            return sum;
        }
        else {
            return sum + find(n, triangle, 1, 0);
        } 
    }
    public int find(int n, List<List<Integer>> triangle, int row, int ind) {

        if (row == n) {
            return 0;
        }

        if (dp[row][ind] != Integer.MAX_VALUE) {
            return dp[row][ind];
        }

        int firstInd = triangle.get(row).get(ind) + find(n, triangle, row + 1, ind);
        int secInd = triangle.get(row).get(ind + 1) + find(n, triangle, row + 1, ind + 1);

        return dp[row][ind] = Math.min(firstInd, secInd);
    }
}
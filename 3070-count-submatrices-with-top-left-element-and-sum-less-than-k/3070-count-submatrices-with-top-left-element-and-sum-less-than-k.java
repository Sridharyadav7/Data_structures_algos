class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;

        int prefix[][] = new int[rows][cols];

        for(int i = 0; i < rows; i++) {
            prefix[i][0] = grid[i][0];

            for(int j = 1; j < cols; j++) {
                prefix[i][j] = prefix[i][j-1] + grid[i][j];
            }
        }

        for(int j = 0; j < cols; j++) {
            for(int i = 1; i < rows; i++) {
                prefix[i][j] = prefix[i-1][j] + prefix[i][j];
            }
        }

        int cnt = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(prefix[i][j] <= k) {
                    cnt++;
                }
                else break;
            }
        }
        return cnt;
    }
}
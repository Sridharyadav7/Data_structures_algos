class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;
        int prefix[][] = new int[rows][cols];

        for(int i = 0; i < rows; i++) {
            prefix[i][0] = mat[i][0];

            for(int j = 1; j < cols; j++) {
                prefix[i][j] = prefix[i][j-1] + mat[i][j]; 
            }
        }
        for(int j = 0; j < cols; j++) {
            for(int i = 1; i < rows; i++) {
                prefix[i][j] = prefix[i-1][j] + prefix[i][j];
            }
        }

        int ans[][] = new int[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                int r1 = Math.max(0, i - k);
                int r2 = Math.min(rows - 1, i + k);
                int c1 = Math.max(0, j - k);
                int c2 = Math.min(cols - 1, j + k);

                int sum = prefix[r2][c2];

                int nr = r1 - 1;
                int nc = c2;

                if(nr >= 0) {
                    sum -= prefix[nr][nc];
                }

                nr = r2;
                nc = c1 - 1;

                if(nc >= 0) {
                    sum -= prefix[nr][nc];
                }

                if(r1 > 0 && c1 > 0) {
                    sum += prefix[r1-1][c1-1];
                }
                ans[i][j] = sum;
            }
        }
        return ans;
    }
}
class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxlen = Math.min(rows, cols);
        int prefix[][] = new int[rows][cols];
        int ans = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    ans++;
                }
                if (j == 0) {
                    prefix[i][j] = matrix[i][j];
                }
                else {
                    prefix[i][j] = prefix[i][j-1] + matrix[i][j];
                }
            }
        }
        for (int j = 0; j < cols; j++) {
            for (int i = 1; i < rows; i++) {
                prefix[i][j] = prefix[i][j] + prefix[i-1][j];
            }
        }
        
        for (int l = 2; l <= maxlen; l++) {
            for (int i = 0; i + l - 1 < rows; i++) {
                int r1 = i;
                int c1 = 0;
                int r2 = r1 + l - 1;
                int c2 = c1 + l - 1;

                while(c2 < cols && r2 < rows) {
                    if(getPrefixSum(prefix, r1, c1, r2, c2) == l * l) {
                        ans++;
                    }
                    c1++;
                    c2++;
                }
            }
        }
        return ans;
    }
    public int getPrefixSum(int prefix[][], int r1, int c1, int r2, int c2) {
        int sum = prefix[r2][c2];

        if(r1 > 0) {
            sum -= prefix[r1-1][c2];
        }
        if (c1 > 0) {
            sum -= prefix[r2][c1-1];
        }
        if (r1 > 0 && c1 > 0) {
            sum += prefix[r1-1][c1-1];
        }

        return sum;
    }
}
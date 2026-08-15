class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int rows = mat.length;
        int cols = mat[0].length;
        int prefix[][] = new int[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                prefix[i][j] = mat[i][j];

                if(i > 0) {
                    prefix[i][j] += prefix[i-1][j];
                }
                if(j > 0) {
                    prefix[i][j] += prefix[i][j-1];
                }
                if(i > 0 && j > 0) {
                    prefix[i][j] -= prefix[i-1][j-1];
                }
            }
        }

        int maxlen = 0;
        for(int size = 1; size <= Math.min(rows, cols); size++) {
            boolean foundGrid = false;

            for(int i = 0; i <= rows - size; i++) {

                for(int j = 0; j <= cols - size; j++) {
                    int r2 = i + size - 1;
                    int c2 = j + size - 1;

                    int sum = sumOfGrid(prefix, i, j, r2, c2);
                    if(sum <= threshold) {
                        maxlen = size;
                        foundGrid = true;
                        break;
                    }
                }
            }
            if (!foundGrid) {
                break;
            }
        }
        return maxlen;
    }

    public int sumOfGrid(int prefix[][], int r1, int c1, int r2, int c2) {
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
        return sum;
    }
}
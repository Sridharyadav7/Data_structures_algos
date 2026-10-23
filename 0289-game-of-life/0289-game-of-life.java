class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int curr[][] = new int[m][n];
        int res[][] = new int[m][n];

        int delRow[] = {-1, -1, -1, 0, 1, 1, 1, 0};
        int delCol[] = {-1, 0, 1, 1, 1, 0, -1, -1};

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int currRow = row;
                int currCol = col;
        
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        curr[i][j] = board[i][j];
                    }
                }

                int live = 0;

                for (int ind = 0; ind < 8; ind++) {
                    int newRow = currRow + delRow[ind];
                    int newCol = currCol + delCol[ind];

                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                        if (board[newRow][newCol] == 1) {
                            live++;
                        }
                    }
                }

                if (board[row][col] == 1) {
                    if (live < 2 || live > 3) {
                        curr[row][col] = 0;
                    }
                    else if (live == 2 || live == 3) {
                        curr[row][col] = 1;
                    }
                }
                else {
                    if (live == 3) {
                        curr[row][col] = 1;
                    }
                }

                res[row][col] = curr[row][col];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = res[i][j];
            }
        }
    }
}
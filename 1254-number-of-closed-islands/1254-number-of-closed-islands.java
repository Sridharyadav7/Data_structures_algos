class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, -1, 0, 1};
        Queue<Pair> que = new LinkedList<>();
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    continue;
                }
                if (grid[i][j] == 0 && !vis[i][j]) {
                    que.add(new Pair(i, j));
                    vis[i][j] = true;
                    boolean touchesBoundary = false;

                    while (!que.isEmpty()) {
                        Pair curr = que.poll();
                        int row = curr.row;
                        int col = curr.col;

                        if (row == 0 || row == m - 1 || col == 0 || col == n - 1) {
                            touchesBoundary = true;
                        }

                        for (int ind = 0; ind < 4; ind++) {
                            int newRow = row + delRow[ind];
                            int newCol = col + delCol[ind];

                            if (newRow < m && newRow >= 0
                            && newCol < n && newCol >= 0
                            && grid[newRow][newCol] == 0 && !vis[newRow][newCol]) {
                                que.add(new Pair(newRow, newCol));
                                vis[newRow][newCol] = true;
                            }
                        }
                    }

                    if (!touchesBoundary) {
                        res++;
                    }
                }
            }
        }

        return res;
    }
}

class Pair {
    int row;
    int col;

    public Pair(int _row, int _col) {
        this.row = _row;
        this.col = _col;
    }
}
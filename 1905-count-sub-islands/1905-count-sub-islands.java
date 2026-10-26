class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int res = 0;
        Queue<Pair> que = new LinkedList<>();
        boolean vis[][] = new boolean[m][n];
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, -1, 0, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid2[i][j] == 1) {
                    que.add(new Pair(i, j));
                    vis[i][j] = true;
                    List<Pair> cells = new ArrayList<>();

                    while (!que.isEmpty()) {
                        Pair curr = que.poll();
                        int row = curr.row;
                        int col = curr.col;
                        cells.add(new Pair(row, col));

                        for (int ind = 0; ind < 4; ind++) {
                            int newRow = row + delRow[ind];
                            int newCol = col + delCol[ind];

                            if (newRow < m && newRow >= 0
                            && newCol < n && newCol >= 0
                            && !vis[newRow][newCol] && grid2[newRow][newCol] == 1) {
                                que.add(new Pair(newRow, newCol));
                                vis[newRow][newCol] = true;
                            }
                        }
                    }

                    boolean isSubIsland = true;
                    for (Pair p : cells) {
                        if (grid1[p.row][p.col] == 0) {
                            isSubIsland = false;
                            break;
                        }
                    }

                    if (isSubIsland) {
                        res += 1;
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
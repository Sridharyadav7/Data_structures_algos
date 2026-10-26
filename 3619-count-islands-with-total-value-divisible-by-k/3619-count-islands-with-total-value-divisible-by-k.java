class Solution {
    public int countIslands(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        boolean vis[][] = new boolean[rows][cols];
        Queue<Pair> que = new LinkedList<>();
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, -1, 0, 1};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!vis[i][j] && grid[i][j] > 0) {
                    que.add(new Pair(i, j));
                    vis[i][j] = true;
                    long sum = 0;

                    while (!que.isEmpty()) {
                        Pair curr = que.poll();
                        int row = curr.row;
                        int col = curr.col;
                        sum += grid[row][col];

                        for (int ind = 0; ind < 4; ind++) {
                            int newRow = row + delRow[ind];
                            int newCol = col + delCol[ind];

                            if (newRow < rows && newRow >= 0 
                            && newCol < cols && newCol >= 0
                            && !vis[newRow][newCol] && grid[newRow][newCol] > 0) {
                                que.add(new Pair(newRow, newCol));
                                vis[newRow][newCol] = true;
                            }
                        }
                    }

                    if (sum % k == 0) {
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

    public Pair (int _row, int _col) {
        this.row = _row;
        this.col = _col;
    }
}
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, -1, 0, 1};

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for(int i = 0; i < cols; i++) {
            dfs(heights, 0, i, rows, cols, Integer.MIN_VALUE, pacific, delRow, delCol);
            dfs(heights, rows-1, i, rows, cols, Integer.MIN_VALUE, atlantic, delRow, delCol);
        }
        for(int i = 0; i < rows; i++) {
            dfs(heights, i, 0, rows, cols, Integer.MIN_VALUE, pacific, delRow, delCol);
            dfs(heights, i, cols - 1, rows, cols, Integer.MIN_VALUE, atlantic, delRow, delCol);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(atlantic[i][j] && pacific[i][j]) {
                    ans.add(List.of(i, j));
                }
            }
        }
        return ans;
    }

    public void dfs(int[][] heights, int r, int c, int rows, int cols, int prevVal, boolean vis[][], int delRow[], int delCol[]) {
        if(r < 0 || r >= rows || c < 0 || c >= cols) return;
        if(heights[r][c] < prevVal || vis[r][c]) return;

        vis[r][c] = true;
        for(int i = 0; i < 4; i++) {
            int nr =  r + delRow[i];
            int nc = c + delCol[i];

            dfs(heights, nr, nc, rows, cols, heights[r][c], vis, delRow, delCol);
        } 
    }

}

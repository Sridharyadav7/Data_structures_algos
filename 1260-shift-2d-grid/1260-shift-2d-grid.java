class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (k == 0) {
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < rows; i++) {
                ans.add(new ArrayList<>());
                for (int j = 0; j < cols; j++) {
                    ans.get(i).add(grid[i][j]);
                }
            }
            return ans;
        }
        int cnt = 0;
        int rowInd = 0;
        int colInd = 1;
        int res[][] = new int[rows][cols];

        while(cnt < k) {
            cnt++;
            for(int i = 0; i < rows; i++) {

                for(int j = 0; j < cols; j++) {
                    if(colInd == cols) {
                        colInd = 0;
                        rowInd++;
                    }
                    if(rowInd == rows) rowInd = 0;

                    res[rowInd][colInd] = grid[i][j];
                    colInd++;
                }
            }
            if(cnt == k) break;
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < cols; j++) {
                    grid[i][j] = res[i][j];
                }
            }
            colInd = 1;
            rowInd = 0;
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < rows; i++) {
            ans.add(new ArrayList<>());
        }
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                ans.get(i).add(res[i][j]);
            }
        }
        return ans;
    }
}
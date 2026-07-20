class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int n = rows * cols;

        k = k % n;
        reverse(grid, cols, 0, n - 1);
        reverse(grid, cols, 0, k - 1);
        reverse(grid, cols, k , n - 1);

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < rows; i++) ans.add(new ArrayList<>());
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                ans.get(i).add(grid[i][j]);
            }
        }
        return ans;
    }
    public void reverse(int[][] grid, int cols, int start, int end) {
        while(start < end) {
            swap(grid, start/cols, start%cols, end/cols, end%cols);
            start++;
            end--;
        }
    }
    public void swap(int[][] grid, int row1, int col1, int row2, int col2) {
        int temp = grid[row1][col1];
        grid[row1][col1] = grid[row2][col2];
        grid[row2][col2] = temp;
    }
}
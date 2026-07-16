class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int res[][] = new int[rows][cols];
        for(int arr[] : res) Arrays.fill(arr, Integer.MAX_VALUE);
        res[0][0] = grid[0][0];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.sum - b.sum);
        pq.add(new Pair(0, 0, grid[0][0]));
        int delRow[] = {0, 1};
        int delCol[] = {1, 0};

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int row = curr.row;
            int col = curr.col;
            int sum = curr.sum;

            if(sum > res[row][col]) continue;
            for(int i = 0; i < 2; i++) {
                int nr = row + delRow[i];
                int nc = col + delCol[i];

                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    int newSum = sum + grid[nr][nc];
                    if(newSum < res[nr][nc]) {
                        res[nr][nc] = newSum;
                        pq.add(new Pair(nr, nc, newSum));
                    }
                }
            }
        }
        return res[rows-1][cols-1];
    }
}

class Pair {
    int row; 
    int col; 
    int sum;

    public Pair(int _row, int _col, int _sum) {
        this.row = _row;
        this.col = _col;
        this.sum = _sum;
    }
}
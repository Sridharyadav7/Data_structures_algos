class Solution {
    public int swimInWater(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int res[][] = new int[rows][cols];
        for(int arr[] : res) Arrays.fill(arr, Integer.MAX_VALUE);
        res[0][0] = grid[0][0];
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, -1, 0, 1};
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dis - b.dis);

        pq.add(new Pair(0, 0, grid[0][0]));
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int row = curr.row;
            int col = curr.col;
            int dis = curr.dis;

            if(dis > res[row][col]) continue;
            for(int i = 0; i < 4; i++) {
                int nr = row + delRow[i];
                int nc = col + delCol[i];

                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    int newDis = Math.max(dis, grid[nr][nc]);
                    if(newDis < res[nr][nc]) {
                        res[nr][nc] = newDis;
                        pq.add(new Pair(nr, nc, newDis));
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
    int dis;

    public Pair(int _row, int _col, int _dis) {
        this.row = _row;
        this.col = _col;
        this.dis = _dis;
    }
}
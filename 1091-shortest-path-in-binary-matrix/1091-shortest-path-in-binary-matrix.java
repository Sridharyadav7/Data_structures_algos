class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid.length;
        if(grid[rows-1][cols-1] == 1 || grid[0][0] == 1) return -1;
        int res[][] = new int[rows][cols];
        int deltaRow[] = {-1, -1, 0, 1, 1, 1, 0, -1};
        int deltaCol[] = {0, -1, -1, -1, 0, 1, 1, 1}; 
        for(int arr[]: res) Arrays.fill(arr, Integer.MAX_VALUE);
        res[0][0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        pq.add(new Pair(0, 0, 1));

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int row = curr.row;
            int col = curr.col;
            int dis = curr.dis;

            if(dis > res[row][col]) continue;
            for(int i = 0; i < 8; i++) {
                int nr = row + deltaRow[i];
                int nc = col + deltaCol[i];

                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 0) {
                    int newDis = dis + 1;
                    if(newDis < res[nr][nc]) {
                        res[nr][nc] = newDis;
                        pq.add(new Pair(nr, nc, newDis));
                    }
                }
            }
        }
        if(res[rows-1][cols-1] ==  Integer.MAX_VALUE) return -1;
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
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int res[][] = new int[rows][cols];
        for(int arr[] : res) Arrays.fill(arr, Integer.MAX_VALUE);
        res[0][0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        pq.add(new Pair(0, 0, 0));
        int deltaRow[] = {-1, 0, 1, 0};
        int deltaCol[] = {0, -1, 0, 1};

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int row = curr.row;
            int col = curr.col;
            int dis = curr.dis;

            for(int i = 0; i < 4; i++) {
                int nr = row + deltaRow[i];
                int nc = col + deltaCol[i];

                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    int diff = Math.abs(heights[row][col] - heights[nr][nc]);
                    int newDis = Math.max(diff, dis);

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
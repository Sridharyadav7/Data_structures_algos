class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, Pair> map = new HashMap<>();
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new Pair(i, j));
            }
        }

        for (int i = 0; i < m; i++) {
            rowMap.put(i, n);
        }

        for (int i = 0; i < n; i++) {
            colMap.put(i, m);
        }

        for (int i = 0; i < arr.length; i++) {
            Pair curr = map.get(arr[i]);
            int row = curr.row;
            int col = curr.col;

            rowMap.put(row, rowMap.get(row) - 1);
            if (rowMap.get(row) == 0) {
                return i;
            }

            colMap.put(col, colMap.get(col) - 1);
            if (colMap.get(col) == 0) {
                return i;
            }
        }

        return 0;
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

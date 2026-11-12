class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Map<Integer, Pair> map = new HashMap<>();
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new Pair(i, j));
            }
        }

        Arrays.fill(rowCount, n);
        Arrays.fill(colCount, m);

        for (int i = 0; i < arr.length; i++) {
            Pair curr = map.get(arr[i]);

            int row = curr.row;
            int col = curr.col;

            rowCount[row]--;
            colCount[col]--;

            if (rowCount[row] == 0 || colCount[col] == 0) {
                return i;
            }
        }

        return -1;
    }
}

class Pair {
    int row, col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
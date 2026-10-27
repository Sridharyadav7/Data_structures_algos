class Solution {
    public String[] createGrid(int m, int n) {
        String[] grid = new String[m];

        for(int i = 0; i < m; i++) {
            StringBuilder row = new StringBuilder("#".repeat(n));

            if (i == 0) {
                for(int j = 0; j < n; j++) {
                    row.setCharAt(j, '.');
                }
            }
            else {
                row.setCharAt(n - 1, '.');
            }
            grid[i] = row.toString();
        }
        return grid;
    }
}
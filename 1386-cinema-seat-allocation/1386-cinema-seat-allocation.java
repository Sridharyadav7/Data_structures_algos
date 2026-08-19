class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Integer> rows = new HashMap<>();

        // Store reserved seats as a bitmask for each row
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            // Only seats 2-9 matter
            if (col >= 2 && col <= 9) {
                rows.put(row, rows.getOrDefault(row, 0) | (1 << col));
            }
        }

        // Every completely empty row can fit 2 families
        int ans = (n - rows.size()) * 2;

        for (int mask : rows.values()) {

            boolean left = (mask & 0b00111100) == 0;   // 2-5
            boolean middle = (mask & 0b11110000) == 0; // 4-7
            boolean right = (mask & 0b1111000000) == 0; // 6-9

            if (left && right) {
                ans += 2;
            } 
            else if (left || middle || right) {
                ans++;
            }
        }

        return ans;
    }
}
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int prevEnd = intervals[0][1];
        int res = 0;

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < prevEnd) {
                res++;
            }
            else {
                prevEnd = intervals[i][1];
            }
        }

        return res;
    }
}
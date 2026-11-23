class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long maxArea = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                int x1 = bottomLeft[i][0];
                int y1 = bottomLeft[i][1];

                int x2 = topRight[i][0];
                int y2 = topRight[i][1];

                int x3 = bottomLeft[j][0];
                int y3 = bottomLeft[j][1];

                int x4 = topRight[j][0];
                int y4 = topRight[j][1];

                if (overlap(x1,y1,x2,y2,x3,y3,x4,y4)) {
                    int x = Math.min(x2, x4) - Math.max(x1, x3);
                    int y = Math.min(y2, y4) - Math.max(y1, y3);
                    int side = Math.min(x, y);
                    long area = (long) side * side;
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }
    public boolean overlap(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        if (x2 <= x3 || y1 >= y4 || x1 >= x4 || y2 <= y3) {
            return false;
        }
        return true;
    }
}
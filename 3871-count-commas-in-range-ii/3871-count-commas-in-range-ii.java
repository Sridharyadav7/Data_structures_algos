class Solution {
    public long countCommas(long n) {
        long cnt = 0;

        if(n < 1000) {
            return 0;
        }
        long largeNum = 999999999999999L;
        long nextLarge = 999999999999L;

        while (n >= 1000) {
            if(n > largeNum) {
                long val = n - largeNum;
                cnt += (val * 5);
                n -= val;
            }
            else if (n > nextLarge) {
                long val = n - nextLarge;
                cnt += (val * 4);
                n -= val;
            }
            else if (n > 999999999) {
                long val = n - 999999999;
                cnt += (val * 3);
                n -= val;
            }
            else if (n > 999999) {
                long val = n - 999999;
                cnt += (val * 2);
                n -= val;
            }
            else if (n > 999) {
                long val = n - 999;
                cnt += val;
                n -= val;
            }
        }
        return cnt;
    }
}
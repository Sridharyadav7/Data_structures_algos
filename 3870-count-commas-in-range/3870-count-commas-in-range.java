class Solution {
    public int countCommas(int n) {
        int cnt = 0;

        while (n > 999) {
            if (n > 999999) {
                int val = n - 999999;
                cnt += (val * 2);
                n -= val;
            } 
            else if (n > 999) {
                int val = n - 999;
                cnt += val;
                n -= val;
            }
        }
        return cnt;
    }
}
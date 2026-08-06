class Solution {
    public int smallestNumber(int n, int t) {
        int ans = n;

        while(true) {
            long prod = product(n);
            if(prod % t == 0) {
                ans = n;
                break;
            }
            else n++;
        }
        return ans;
    }
    public long product(int num) {
        long prod = 1;

        while(num > 0) {
            prod *= num % 10;
            num /= 10;
        }
        return prod;
    }
}
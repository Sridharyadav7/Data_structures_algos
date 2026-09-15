class Solution {
    int MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        if (n == 1) {
            return 5;
        }
        int ans = 0;
        if (n % 2 == 0) {
            ans = power(5, n / 2);
            ans = (int) ((long) ans * power(4, n / 2) % MOD);
        }
        else {
            ans = power(5, (n/2) + 1);
            ans = (int) (((long)ans * power(4, n/2)) % MOD);
        }

        return ans;
    }
    public int power(int x, long n) {
        if (n == 0) {
            return 1;
        }
        int half = power(x, n / 2);
        long square = (long) half * half % MOD;

        if (n % 2 == 0) {
            return (int) square;
        }

        return (int) (square * x % MOD);
    }
}
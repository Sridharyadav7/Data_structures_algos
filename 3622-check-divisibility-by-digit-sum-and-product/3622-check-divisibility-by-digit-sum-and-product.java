class Solution {
    public boolean checkDivisibility(int n) {
        return (n % (digitSum(n) + productSum(n)) == 0);
    }
    public int digitSum(int n) {
        int sum = 0;

        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public long productSum(int n) {
        long prod = 1;

        while(n > 0) {
            prod *= n % 10;
            n /= 10;
        }
        return prod;
    }

}
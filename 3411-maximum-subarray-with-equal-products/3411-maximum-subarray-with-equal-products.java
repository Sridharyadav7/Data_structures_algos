class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 1;

        for (int i = 0; i < n - 1; i++) {
            long prod = nums[i];
            long gcd = nums[i];
            long lcm = nums[i];

            for (int j = i+1; j < n; j++) {
                prod *= nums[j];
                gcd = findGCD(gcd, (long) nums[j]);
                lcm = findLCM(lcm, (long) nums[j]);

                if (prod == (lcm * gcd)) {
                    ans = Math.max(ans, j - i + 1);
                }
                else {
                    break;
                }
            }
        }
        return ans;
    }

    public long findGCD(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public long findLCM(long a, long b) {
        return (a / findGCD(a, b)) * b;
    }
}
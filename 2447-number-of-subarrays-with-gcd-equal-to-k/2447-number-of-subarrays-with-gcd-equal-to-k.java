class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            int gcd = nums[i];
            for (int j = i; j < n; j++) {
                gcd = getGCD(gcd, nums[j]);
                if (gcd == k) {
                    res += 1;
                }
            }
        }

        return res;
    }
    public int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length;
        int maxEle = 0;
        int minEle = 1000;

        for(int i = 0; i < n; i++) {
            maxEle = Math.max(nums[i], maxEle);
            minEle = Math.min(nums[i], minEle);
        }

        if(maxEle == minEle) return minEle;
        return gcd(maxEle, minEle);
    }
    public int gcd(int a, int b) {
        int num1 = 0;
        int num2 = 0;
        if(a > b) {
            num2 = a;
            num1 = b;
        }
        else {
            num2 = b;
            num1 = a;
        }
        while(num1 > 0) {
            int temp = num2 % num1;
            num2 = num1;
            num1 = temp;
        }
        return num2;
    }
}
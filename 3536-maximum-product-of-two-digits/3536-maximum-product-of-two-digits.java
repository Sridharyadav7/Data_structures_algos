class Solution {
    public int maxProduct(int n) {
        int num1 = -1;
        int num2 = -1;

        while(n > 0) {
            int digit = n % 10;
            if(digit > num1) {
                num2 = num1;
                num1 = digit;
            }
            else if(digit >= num2) {
                num2 = digit;
            }
            n /= 10;
        }
        return num1 * num2;
    }
}
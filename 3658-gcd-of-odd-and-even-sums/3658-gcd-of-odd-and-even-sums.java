class Solution {
    public int gcdOfOddEvenSums(int n) {
        int oddSum = 0;
        int evenSum = 0;
        int cnt = 0;
        int i = 1;
        while(cnt < 2 * n) {
            if(i % 2 == 0) {
                evenSum += i;
            }
            else oddSum += i;
            i++;
            cnt++;
        } 
        int num1 = 0;
        int num2 = 0;
        if(oddSum > evenSum) {
            num2 = oddSum;
            num1 = evenSum;
        }
        else {
            num2 = evenSum;
            num1 = oddSum;
        }
        while(num1 > 0) {
            int mod = num2 % num1;
            num2 = num1;
            num1 = mod;
        }
        return num2;
    }
}
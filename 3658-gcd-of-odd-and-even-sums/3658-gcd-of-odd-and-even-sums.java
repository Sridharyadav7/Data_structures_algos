class Solution {
    public int gcdOfOddEvenSums(int n) {
        int oddSum = n * n;
        int evenSum = n * (n + 1); 
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
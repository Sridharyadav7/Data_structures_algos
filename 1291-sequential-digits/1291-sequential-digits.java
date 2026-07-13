class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        int num1 = low;
        int num2 = high;
        int minLen = 0;
        while(num1 > 0) {
            minLen++;
            num1 /= 10;
        }
        int maxLen = 0;
        while(num2 > 0) {
            maxLen++;
            num2 /= 10;
        }
        maxLen = Math.min(maxLen, 9);
        while(minLen <= maxLen) {
            for(int firstDigit = 1; firstDigit <= 10 - minLen; firstDigit++) {
                int result = nextInteger(firstDigit, minLen);
                if(result >= low && result <= high){
                    ans.add(result);
                }
                else if(result > high) {
                    break;
                }
            }
            minLen++;
        }
        return ans;
    }
    public int nextInteger(int firstDigit, int len) {
        StringBuilder sb = new StringBuilder(Integer.toString(firstDigit));
        for(int i = 1; i < len; i++) {
            firstDigit++;
            sb.append(Integer.toString(firstDigit));
        }
        return Integer.parseInt(sb.toString());
    }
}
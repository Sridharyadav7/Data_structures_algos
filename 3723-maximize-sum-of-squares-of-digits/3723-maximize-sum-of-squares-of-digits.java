class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        while (cnt < num && sum > 0) {
            int val = Math.min(9, sum);
            sum -= val;
            sb.append(Integer.toString(val));
            cnt++;
        }

        if (sum > 0) {
            return "";
        }

        while (cnt < num) {
            sb.append("0");
            cnt++;
        }

        return sb.toString();
    }
}
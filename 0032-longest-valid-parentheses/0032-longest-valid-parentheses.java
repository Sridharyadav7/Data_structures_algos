class Solution {

    public int longestValidParentheses(String s) {
        int n = s.length();
        int ans1 = 0;
        int ans2 = 0;
        int open = 0;
        int close = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                open++;
            }
            else {
                close++;
                if (close > open) {
                    open = 0;
                    close = 0;
                }
                else if (open == close) {
                    ans1 = Math.max(ans1, open + close);
                }
            }
        }

        open = 0;
        close = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                close++;
            }
            else {
                open++;
                if (open > close) {
                    open = 0;
                    close = 0;
                }
                else if (open == close) {
                    ans2 = Math.max(ans2, open + close);
                }
            }
        }

        return Math.max(ans1, ans2);
    }
   
}
class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        int start = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                cnt++;
            }
            else {
                cnt--;

                if (cnt == 0) {
                    sb.append(s.substring(start + 1, i));
                    start = i+1;
                }
            }
        }

        return sb.toString();
    }
}
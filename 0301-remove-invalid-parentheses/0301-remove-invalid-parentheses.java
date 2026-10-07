class Solution {
    int n;
    int minRemovals;

    public List<String> removeInvalidParentheses(String s) {
        n = s.length();
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        minRemovals = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ')') {
                cnt--;

                if (cnt < 0) {
                    minRemovals += 1;
                    cnt = 0;
                }
            }
            else if (c == '(') {
                cnt++;
            }
        }

        minRemovals += cnt;

        solve(s, sb, 0, 0, set);
        for (String str : set) {
            ans.add(str);
        }
        return ans;
    }
    public void solve(String s, StringBuilder sb, int i, int removals, Set<String> set) {
        if (i == n) {
            if (removals == minRemovals && isValid(sb.toString())) {
                set.add(sb.toString());
            }
            return;
        }
        char c = s.charAt(i);

        if (c == '(' || c == ')') {
            sb.append(c);
            solve(s, sb, i+1, removals, set);
            sb.deleteCharAt(sb.length() - 1);
            solve(s, sb, i+1, removals + 1, set);
        }
        else {
            sb.append(c);
            solve(s, sb, i+1, removals, set);
            sb.deleteCharAt(sb.length() - 1);
        }
        return;
    }
    public boolean isValid(String s) {
        int len = s.length();
        int cnt = 0;

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ')') {
                cnt--;

                if (cnt < 0) {
                    return false;
                }
            }
            else if (c == '(') {
                cnt++;
            }
        }

        return cnt == 0 ? true : false;
    }
}
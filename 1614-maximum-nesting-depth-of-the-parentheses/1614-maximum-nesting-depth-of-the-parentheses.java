class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int cnt = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            
            if (s.charAt(i) == '(') {
                cnt++;
                ans = Math.max(ans, cnt);
            }
            else if (s.charAt(i) == ')') {
                cnt--;
            }
        }
        return ans;
    }
}
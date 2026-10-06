class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        int ans = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
             if (c == ')') {
                cnt--;

                if (cnt == -1) {
                    ans += 1;
                    cnt = 0;
                }
             }
             else {
                cnt++;
             }
        }

        return ans + cnt;
    }
}
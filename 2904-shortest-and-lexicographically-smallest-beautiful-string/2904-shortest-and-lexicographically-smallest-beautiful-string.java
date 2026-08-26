class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int ones = 0;
        int l = 0;
        int minlen = 101;
        String ans = "";

        for (int r = 0; r < n; r++) {
            if(s.charAt(r) == '1') {
                ones++;
            }

            while(ones > k) {
                if(s.charAt(l) == '1') {
                    ones--;
                }
                l++;
            }
            while (ones == k) {
                String curr = s.substring(l , r + 1);

                if(ans.equals("") || ans.length() > curr.length()) {
                    ans = curr;
                }
                else if(ans.length() == curr.length() && curr.compareTo(ans) < 0) {
                    ans = curr;
                } 

                if(s.charAt(l) == '1') {
                    ones--;
                }
                l++;
            }
        }
        return ans;
    }
}
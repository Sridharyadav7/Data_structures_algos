class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int ones = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) - '0' == 1) {
                ones++;
            }
        }
        List<Integer> zeroes = new ArrayList<>();
        int i = 0;
        int cnt = 0;
        while(i < n) {
            if(s.charAt(i) - '0' == 0) {
                cnt = 0;
                while(i < n && s.charAt(i) - '0' == 0) {
                    cnt++;
                    i++;
                }
                zeroes.add(cnt);
            }
            else i++;
        }
        int ans = 0;
        for(i = 1; i < zeroes.size(); i++) {
            ans = Math.max(ans, zeroes.get(i-1) + zeroes.get(i));
        }
        return ans + ones;
    }
}
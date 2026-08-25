class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        int ans = 1;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int dp[] = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(words[j].length() == words[i].length() - 1 && isPredecessor(words[j], words[i])) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                } 
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public boolean isPredecessor(String s1, String s2) {
        int i;
        int j;
        i = j = 0;
        int skipped = 0;

        while (i < s1.length() && j < s2.length()) {

            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            }
            else if (skipped < 1) {
                j++;
                skipped++;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
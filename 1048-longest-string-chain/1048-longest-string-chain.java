class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        int ans = 1;
        int dp[] = new int[n+1];
        Arrays.fill(dp, 1);

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isPredecessor(words[i], words[j])) {
                    dp[j] = Math.max(dp[j], 1 + dp[i]);
                }
                ans = Math.max(dp[j], ans);
            }
        }
        return ans;
    }

    public boolean isPredecessor(String word1, String word2) {
        String s1;
        String s2;

        if (word1.length() < word2.length()) {
            s1 = word1;
            s2 = word2;
        }
        else {
            s1 = word2;
            s2 = word1;
        }

        if (s1.length() != s2.length() - 1) {
            return false;
        }

        int diff = 0;
        int i = 0;
        int j = 0;

        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            }
            else {
                diff++;
                j++;
            }
        }
        if (j == s2.length() - 1) {
            diff++;
        }
        return diff == 1 ? true : false;
    }
}
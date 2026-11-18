class Solution {
    public int minChanges(String s) {
        int n = s.length();
        int ones = 0;
        int zeroes = 0;
        int ops = 0;

        for (int i = 1; i < n; i += 2) {
            if (s.charAt(i) != s.charAt(i-1)) {
                ops++;
            }
        }

        return ops;
    }
}
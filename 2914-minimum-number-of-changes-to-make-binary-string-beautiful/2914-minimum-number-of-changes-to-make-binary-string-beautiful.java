class Solution {
    public int minChanges(String s) {
        int n = s.length();
        int ops = 0;

        for (int i = 1; i < n; i += 2) {
            if (s.charAt(i) != s.charAt(i-1)) {
                ops++;
            }
        }

        return ops;
    }
}
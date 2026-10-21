class Solution {
    public int minOperations(String s) {
        int n = s.length();

        if (isSorted(s, 0, n - 1)) {
            return 0;
        }

        if (n == 2) {
            return -1;
        }

        char minChar = 'z';
        char maxChar = 'a';

        for (int i = 0; i < n; i++) {
            minChar = (char) Math.min(minChar, s.charAt(i));
            maxChar = (char) Math.max(maxChar, s.charAt(i));
        }

        if (s.charAt(0) == minChar || s.charAt(n - 1) == maxChar) {
            return 1;
        }

        if (s.charAt(0) == maxChar && s.charAt(n - 1) == minChar) {
            int maxCount = 0;
            int minCount = 0;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == maxChar) {
                    maxCount++;
                }
                if (s.charAt(i) == minChar) {
                    minCount++;
                }
            }

            if (maxCount == 1 && minCount == 1) {
                return 3;
            }
        }

        return 2;
    }

    public boolean isSorted(String s, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                return false;
            }
        }

        return true;
    }
}
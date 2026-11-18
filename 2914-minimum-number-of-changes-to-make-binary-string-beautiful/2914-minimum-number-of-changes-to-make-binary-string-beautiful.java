class Solution {
    public int minChanges(String s) {
        int n = s.length();
        int ones = 0;
        int zeroes = 0;
        int ops = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                zeroes++;
            }
            else {
                ones++;
            }

            if (i % 2 == 1) {
                if (ones == zeroes) {
                    ops++;
                }
                zeroes = 0;
                ones = 0;
            }
        }

        return ops;
    }
}
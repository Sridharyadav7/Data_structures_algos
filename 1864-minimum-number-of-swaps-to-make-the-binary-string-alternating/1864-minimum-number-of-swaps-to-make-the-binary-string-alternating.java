class Solution {
    public int minSwaps(String s) {
        int n = s.length();
        int ones = 0;
        int zeroes = 0;
        boolean isAlternating = true;

        if (s.charAt(0) == '1') {
            ones++;
        }
        else {
            zeroes++;
        }

        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);

            if (isAlternating && s.charAt(i-1) == c) {
                isAlternating = false;
            }
            if (c == '0') {
                zeroes++;
            }
            else {
                ones++;
            }
        }

        if (isAlternating) {
            return 0;
        }
        if (ones > zeroes + 1 || zeroes > ones + 1) {
            return -1;
        }

        int diff0 = 0;
        int diff1 = 0;

        for (int i = 0; i < n; i++) {
            char expected0 = (i % 2 == 0) ? '0' : '1';
            char expected1 = (i % 2 == 0) ? '1' : '0';

            if (s.charAt(i) != expected0) diff0++;
            if (s.charAt(i) != expected1) diff1++;
        }

        if (ones > zeroes) {
            return diff1 / 2;
        }
        else if (zeroes > ones) {
            return diff0 / 2;
        }
        else {
            return Math.min(diff0, diff1) / 2;
        }
    }
}
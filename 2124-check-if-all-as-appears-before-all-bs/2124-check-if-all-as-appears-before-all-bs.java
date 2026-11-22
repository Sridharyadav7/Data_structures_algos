class Solution {
    public boolean checkString(String s) {
        int n = s.length();
        int a = -1;
        int b = -1;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                a = i;
            }
            else if (b == -1 && c == 'b') {
                b = i;
            }
        }

        if (b == -1) {
            return true;
        }

        return a < b ? true : false;
    }
}
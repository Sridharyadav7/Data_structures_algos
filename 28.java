class Solution {
    public int strStr(String haystack, String needle) {
        int i;
        for (i = 0; i <= (haystack.length() - needle.length()); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i, i + needle.length()).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
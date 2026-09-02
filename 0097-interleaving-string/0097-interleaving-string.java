class Solution {
    int len1;
    int len2;
    int len3;
    Boolean dp[][][] = new Boolean[101][101][201];

    public boolean isInterleave(String s1, String s2, String s3) {
        len1 = s1.length();
        len2 = s2.length();
        len3 = s3.length();

        if (len1 + len2 != len3) {
            return false;
        }
        return check(s1, s2, s3, 0, 0, 0);
    }
    public boolean check(String s1, String s2, String s3, int i, int j, int k) {

        if (k == len3) {
            return true;
        }
        
        boolean takeS1 = false;
        boolean takeS2 = false;

        if (dp[i][j][k] != null) {
            return dp[i][j][k];
        }

        if (i < len1 && s1.charAt(i) == s3.charAt(k)) {
            takeS1 = check(s1, s2, s3, i+1, j, k+1);
        }
        if (j < len2 && s2.charAt(j) == s3.charAt(k)) {
            takeS2 = check(s1, s2, s3, i, j+1, k+1);
        }
        return dp[i][j][k] = takeS1 || takeS2;
    }
}
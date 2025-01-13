class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.equals("")) return true;
        int i=0;
        int j=0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
            }
            j=j+1;
            if(i==s.length()) return true;
        }
        return false;
    }
}
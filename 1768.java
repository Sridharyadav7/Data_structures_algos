class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i=0;
        String result="";
        while(i<word1.length() && i<word2.length()){
            result=result+word1.charAt(i);
            result=result+word2.charAt(i);
            i++;
        }
        while(i<word1.length()){
            result=result+word1.charAt(i);
            i++;
        }
        while(i<word2.length()){
            result=result+word2.charAt(i);
            i++;
        }
        return result;
    }
}
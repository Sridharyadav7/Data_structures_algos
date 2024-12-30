class Solution {
    public int lengthOfLastWord(String s) {
        String new_s=s.trim();
        int j=new_s.length()-1;
        while(new_s.charAt(j)!=' ' && j>0){
            j--;
        }
        if(j==0) return new_s.length();
        else return new_s.length()-j-1;
    }
}
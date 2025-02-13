class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int r[] = new int[26];
        int m[] = new int[26];
        for(int i=0;i<ransomNote.length();i++){
            r[ransomNote.charAt(i)-97]++;
        }
        int cnt=0;
        for(int i=0;i<magazine.length();i++){
            if(r[magazine.charAt(i)-97]>0){
                r[magazine.charAt(i)-97]--;
                cnt++;
            }
        }
        if(cnt==ransomNote.length()) return true;
        else return false;
    }
}
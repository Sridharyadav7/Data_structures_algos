class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()==t.length()){
            int f[]=new int[26];
            for(int i=0;i<s.length();i++){
                f[s.charAt(i)-97]++;
            }
            for(int i=0;i<s.length();i++){
                f[t.charAt(i)-97]--;
            }
            for(int i=0;i<f.length;i++){
                if(f[i]!=0){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
}
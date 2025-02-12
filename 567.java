class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int str1[] = new int[26];
        int sol[] = new int[26];
        int i=0;
        while(i<s1.length()){
            str1[s1.charAt(i)-97]++;
            i++;
        }
        
        for(i=0;i<s2.length();i++){
            if(str1[s2.charAt(i)-97]>0){
                if(s1.length()==1) return true;
                sol[s2.charAt(i)-97]++;
                int j=i+1;
                int k=1;
                while(j<s2.length() && (str1[s2.charAt(j)-97]>0 && str1[s2.charAt(j)-97]>sol[s2.charAt(j)-97]) && k<s1.length()){
                    sol[s2.charAt(j)-97]++;
                    j++;
                    k++;
                }
                if(k==s1.length()) return true;
                else sol=new int[26];
            }
        }
        return false;
    }
}
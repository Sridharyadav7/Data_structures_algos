class Solution {
    public String firstPalindrome(String[] words) {
        int n = words.length;
        for(int i = 0; i < n; i++) {
            if(isPalindrome(words[i])) return words[i];
        }
        return "";
    }
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
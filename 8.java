class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int sign = 1;
        long result = 0;
        
        
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        
        if (i == s.length()) return 0;
    
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        
        
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } 
            i++;
        }  
        return (int)(sign * result);
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        HashMap < Character, Integer > map = new HashMap < Character, Integer >();
        int len=1;
        int left=0,right=0;
        while(right<s.length()){
            char currentChar=s.charAt(right);
            if (map.containsKey(currentChar) && map.get(currentChar) >= left) {
            left = map.get(currentChar) + 1;
        }
        map.put(currentChar, right);
        len = Math.max(len, right - left + 1);
        right++;
        }
        return len;
    }
}
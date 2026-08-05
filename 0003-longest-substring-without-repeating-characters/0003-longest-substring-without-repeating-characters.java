class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        
        for(int right = 0; right < n; right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            while(map.size() < right - left + 1) {
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                if(map.get(s.charAt(left)) <= 0) {
                    map.remove(s.charAt(left));
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
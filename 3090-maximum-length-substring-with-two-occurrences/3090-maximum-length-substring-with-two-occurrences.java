class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        if(n <= 2) return n;
        Map<Character, Integer> map = new HashMap<>();
        int maxlen = 0;
        int l = 0;

        for(int r = 0; r < n; r++) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            int maxf = map.get(c);

            if(maxf <= 2) {
                maxlen = Math.max(maxlen, r - l + 1);
            }

            while(maxf > 2) {
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) - 1);
                l++;
                maxf = map.get(c);
            }
        }
        return maxlen;
    }
}
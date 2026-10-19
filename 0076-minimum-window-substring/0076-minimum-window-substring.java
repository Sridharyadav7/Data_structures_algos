class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        Map<Character, Integer> map = new HashMap<>();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            cnt++;
        }

        int l = 0;
        int minLen = 100000;
        int start = -1;

        for (int r = 0; r < m; r++) {
            char c = s.charAt(r);

            if (map.containsKey(c)) {
                if (map.get(c) > 0) {
                    cnt--;
                }
                map.put(c, map.get(c) - 1);
            }

            while (cnt == 0) {
                if (r - l + 1 < minLen) {
                    start = l;
                    minLen = r - l + 1;
                }
                c = s.charAt(l);
                if (map.containsKey(c)) {
                    if (map.get(c) > -1) {
                        cnt++;
                    }
                    map.put(c, map.get(c) + 1);
                }
                l++;
            }
        }

        if (start == -1) {
            return "";
        }

        return s.substring(start, start + minLen);
    }
}
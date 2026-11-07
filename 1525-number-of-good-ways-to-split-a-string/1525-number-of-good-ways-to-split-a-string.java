class Solution {
    public int numSplits(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Set<Character> set = new HashSet<>();
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i-1);
            set.add(c);

            map.put(c, map.getOrDefault(c, 0) - 1);

            if (map.get(c) <= 0) {
                map.remove(c);
            }

            if (set.size() == map.size()) {
                ans++;
            }
        }

        return ans;
    }
}
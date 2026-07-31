class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        Map<Character, Integer> map = new HashMap<>();
        int cnt = 0;
        int val = 1;
        int ans = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.freq - a.freq);
        for(int i = 0; i < n; i++) {
            char c = word.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(Character key : map.keySet()) {
            pq.add(new Pair(key, map.get(key)));
        }

        while(!pq.isEmpty()) {
            int freq = pq.poll().freq;
            if(cnt < 8) {
                cnt++;
            }
            else {
                val++;
                cnt = 1;
            }
            ans += freq * val;
        }
        return ans;
    }
}

class Pair {
    char c;
    int freq;

    public Pair(int _c, int _freq) {
        this.c = c;
        this.freq = _freq;
    }
}
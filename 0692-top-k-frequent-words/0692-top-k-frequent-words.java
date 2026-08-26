class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length;
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if(a.freq == b.freq) {
                return b.word.compareTo(a.word); 
            }
            return Integer.compare(a.freq, b.freq);
        });

        for (String key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(new Pair(key, map.get(key)));
            }
            else {
                int curr = map.get(key);
                Pair worst = pq.peek();

                if (pq.peek().freq < curr || (curr == worst.freq && key.compareTo(worst.word) < 0)) {
                    pq.poll();
                    pq.add(new Pair(key, curr));
                }
            }
        }

        List<String> ans = new ArrayList<>();
        while(!pq.isEmpty()) {
            ans.add(pq.poll().word);
        }

        Collections.reverse(ans);
        return ans;
    }
}

class Pair {
    String word;
    int freq;

    public Pair (String _word, int _freq) {
        this.word = _word;
        this.freq = _freq;
    }
}
class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.compTime, b.compTime);
        });

        int n = arrival.length;
        int cnt[] = new int[k];
        int res = 0;

        for (int i = 0; i < n; i++) {
            int currTime = arrival[i];

            while (!pq.isEmpty() && pq.peek().compTime <= currTime) {
                available.add(pq.poll().server);
            }

            int start = i % k;
            Integer server = available.ceiling(start);
            if (server == null) {
                server = available.isEmpty() ? null : available.first();
            }
            if (server == null) {
                continue;
            }

            available.remove(server);
            cnt[server]++;
            res = Math.max(res, cnt[server]);
            int compTime = currTime + load[i];
            pq.add(new Pair(server, compTime));
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (cnt[i] == res) {
                list.add(i);
            }
        }

        return list;
    }

}

class Pair {
    int server;
    int compTime;

    public Pair (int _server, int _compTime) {
        this.server = _server;
        this.compTime = _compTime;
    }
}
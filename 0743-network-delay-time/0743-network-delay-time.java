class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<Edge> adj[] = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i < times.length; i++) {
            adj[times[i][0]].add(new Edge(times[i][1], times[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if(a.time == b.time) return a.v - b.v;
            return a.time - b.time;
        });
        int res[] = new int[n+1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[k] = 0;
        pq.add(new Pair(k, 0));

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.v;
            int time = curr.time;

            if(time > res[u]) continue;
            for(Edge edge : adj[u]) {
                int newTime = time + edge.time;
                int v = edge.v;

                if(newTime < res[v]) {
                    pq.add(new Pair(v, newTime));
                    res[v] = newTime;
                } 
            }
        }
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            if(res[i] == Integer.MAX_VALUE) return -1;
            if(res[i] > ans) ans = res[i];
        }
        return ans;
    }
}

class Pair {
    int v;
    int time;

    public Pair(int _v, int _time) {
        this.v = _v;
        this.time = _time;
    }
}

class Edge {
    int v;
    int time;

    public Edge(int _v, int _time) {
        this.v = _v;
        this.time = _time;
    }
}
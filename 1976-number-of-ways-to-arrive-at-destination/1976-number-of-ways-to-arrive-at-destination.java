class Solution {
    public int countPaths(int n, int[][] roads) {
        List<Pair> adj[] = new ArrayList[n];
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i < roads.length; i++) {
            adj[roads[i][0]].add(new Pair(roads[i][1], roads[i][2]));
            adj[roads[i][1]].add(new Pair(roads[i][0], roads[i][2]));
        } 
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if(a.dis == b.dis) return a.node - b.node;
            return Long.compare(a.dis, b.dis);
        });
        long res[] = new long[n];
        Arrays.fill(res, Long.MAX_VALUE);
        res[0] = 0;
        long ans = Long.MAX_VALUE;
        int ways[] = new int[n];
        ways[0] = 1;
        pq.add(new Pair(0, 0));
        int MOD = 1_000_000_007;

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            long dis = curr.dis;

            if(dis > res[u]) continue;
            for(Pair edge : adj[u]) {
                int v = edge.node;
                long newDis = dis + edge.dis;

                if(newDis < res[v]) {
                    res[v] = newDis;
                    pq.add(new Pair(v, newDis));
                    ways[v] = ways[u];
                }
                else if(newDis == res[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }
        return ways[n-1];
    }
}

class Pair {
    int node;
    long dis;

    public Pair(int _node, long _dis) {
        this.node = _node;
        this.dis = _dis;
    }
}
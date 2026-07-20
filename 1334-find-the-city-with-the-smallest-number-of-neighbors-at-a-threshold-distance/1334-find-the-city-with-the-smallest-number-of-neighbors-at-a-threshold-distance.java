class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<Pair> adj[] = new ArrayList[n];
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i < edges.length; i++) {
            adj[edges[i][0]].add(new Pair(edges[i][1], edges[i][2]));
            adj[edges[i][1]].add(new Pair(edges[i][0], edges[i][2]));
        }
        int ans = 0;
        int minVal = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int val = noOfCities(n, adj, i, distanceThreshold);
            if(val <= minVal) {
                ans = i;
                minVal = val;
            }
        }
        return ans;
    }
    public int noOfCities(int n, ArrayList<Pair> adj[], int src, int distanceThreshold) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if(a.dis == b.dis) return a.node - b.node;
            return a.dis - b.dis;
        });
        int cnt = 0;
        int res[] = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[src] = 0;
        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            int dis = curr.dis;

            for(Pair edge : adj[u]) {
                int newDis = dis + edge.dis;
                int v = edge.node;

                if(newDis < res[v]) {
                    pq.add(new Pair(v, newDis));
                    res[v] = newDis;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            if(i != src && res[i] <= distanceThreshold) cnt++;
        }
        return cnt;
    }
}

class Pair {
    int node;
    int dis;

    public Pair(int _node, int _dis) {
        this.node = _node;
        this.dis = _dis;
    }
}
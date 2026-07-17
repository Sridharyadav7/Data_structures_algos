class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<Edge> adj[] = new ArrayList[n];
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i < flights.length; i++) {
            adj[flights[i][0]].add(new Edge(flights[i][1], flights[i][2]));
        }
        Queue<Pair> pq = new LinkedList<>();
        int res[] = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[src] = 0;
        pq.add(new Pair(src, 0));
        int stops = 0;

        while(!pq.isEmpty() && stops <= k) {
            int V = pq.size();

            while(V > 0) {
                Pair curr = pq.poll();
                int u = curr.node;
                int price = curr.price;

                for(Edge edge : adj[u]) {
                    int v = edge.node;
                    int newPrice = price + edge.price;

                    if(newPrice < res[v]) {
                        res[v] = newPrice;
                        pq.add(new Pair(v, newPrice));
                    }
                }
                V--;
            }
            stops++;
        }
        if(res[dst] == Integer.MAX_VALUE) return -1;
        return res[dst];
    }
}

class Edge {
    int node;
    int price;

    public Edge(int _node, int _price) {
        this.node = _node;
        this.price = _price;
    }
}

class Pair {
    int node;
    int price;

    public Pair(int _node, int _price) {
        this.node = _node;
        this.price = _price;
    }
}
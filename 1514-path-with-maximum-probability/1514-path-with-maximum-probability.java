class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<Edge> adj[] = new ArrayList[n];
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i < edges.length; i++) {
            adj[edges[i][0]].add(new Edge(edges[i][1], succProb[i]));
            adj[edges[i][1]].add(new Edge(edges[i][0], succProb[i]));
        }
        double res[] = new double[n];
        Arrays.fill(res, 0);
        res[start_node] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if(a.prob == b.prob) return b.node - a.node;
            return Double.compare(b.prob, a.prob);
        });
        pq.add(new Pair(start_node, 1));

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            double currProb = curr.prob;

            for(Edge edge : adj[u]) {
                int v = edge.node;
                double newProb = currProb * edge.prob;

                if(newProb > res[v]) {
                    res[v] = newProb;
                    pq.add(new Pair(v, newProb));
                }
            }
        }
        return res[end_node];
    }
}

class Pair {
    int node;
    double prob;

    public Pair(int _node, double _prob) {
        this.node = _node;
        this.prob = _prob;
    }
}

class Edge {
    int node;
    double prob;

    public Edge(int _node, double _prob) {
        this.node = _node;
        this.prob = _prob;
    }
}
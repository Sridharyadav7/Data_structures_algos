class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<Edge> adj[] = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                int dis = Math.abs(points[j][0] - points[i][0]) + Math.abs(points[j][1] - points[i][1]);
                adj[i].add(new Edge(j, dis));
                adj[j].add(new Edge(i, dis));
            }
        }

        boolean vis[] = new boolean[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        pq.add(new Pair(0, 0, -1));
        int sum = 0;
        
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int currNode = curr.currNode;
            int parent = curr.parent;
            int dis = curr.dis;

            if(!vis[currNode]) {

                vis[currNode] = true;
                sum += dis;

                for(Edge e : adj[currNode]) {
                    if(!vis[e.node]) {
                        pq.add(new Pair(e.dis, e.node, currNode));
                    }
                }
            }
        }

        return sum;
    }
}

class Edge {
    int node;
    int dis;

    public Edge(int _node, int _dis) {
        this.node = _node;
        this.dis = _dis;
    }
}

class Pair {
    int dis;
    int currNode;
    int parent;

    public Pair(int _dis, int _currNode, int _parent) {
        this.dis = _dis;
        this.currNode = _currNode;
        this.parent = _parent;
    }
}
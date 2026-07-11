class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<Integer> adj[] = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges.length; i++) {
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        boolean vis[] = new boolean[n];
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                int cnt[] = bfs(adj, i, vis);
                int nodes = cnt[0];
                int noOfEdges = cnt[1];
                int val = (nodes * (nodes - 1)) / 2;
                if(noOfEdges == val) ans++;
            }
        }
        return ans;
    }
    public int[] bfs(ArrayList<Integer> adj[], int u, boolean vis[]) {
        Queue<Integer> que = new LinkedList<>();
        que.add(u);
        vis[u] = true;
        int noOfNodes = 0;
        int noOfEdges = 0;
        
        while(!que.isEmpty()) {
            int curr = que.poll();
            noOfNodes++;

            for(int v : adj[curr]) {
                noOfEdges++;

                if(!vis[v]) {
                    vis[v] = true;
                    que.add(v);
                }
            } 
        }
        return new int[]{noOfNodes, noOfEdges / 2};
    }
}
class Solution {
    public int minReorder(int n, int[][] connections) {
        Set<Integer> set[] = new HashSet[n];
        ArrayList<Integer> adj[] = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            set[i] = new HashSet<>();
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1]; 

            set[u].add(v);
            adj[v].add(u);
            adj[u].add(v);
        }

        boolean vis[] = new boolean[n];
        int cnt[] = new int[1];
        dfs(adj, set, 0, cnt, vis);
        return cnt[0];
    }
    public void dfs(ArrayList<Integer> adj[], Set<Integer> set[], int u, int cnt[], boolean vis[]) {
        vis[u] = true;

        for(int v : adj[u]) {
            if(!vis[v] && !set[v].contains(u)) {
                cnt[0] += 1;
            }
            if(!vis[v]) dfs(adj, set, v, cnt, vis);
        }
    }
}
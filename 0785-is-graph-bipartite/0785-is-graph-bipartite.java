class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        boolean vis[] = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!vis[i] && !dfs(graph, i, vis, color, 1)) {
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int[][] graph, int u, boolean vis[], int color[], int col) {
        col = 1 - col;
        color[u] = col;
        vis[u] = true;

        for(int v : graph[u]) {
            if(vis[v] && color[v] == col) {
                return false;
            }
            if(!vis[v] && !dfs(graph, v, vis, color, col)) {
                return false;
            }
        }
        return true;
    }
}
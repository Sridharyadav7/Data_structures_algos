class Solution {
    int ans = -1;
    public int longestCycle(int[] edges) {
        int V = edges.length;
        int count[] = new int[V];
        boolean vis[] = new boolean[V];
        boolean inRecursion[] = new boolean[V];
        Arrays.fill(count, 1);
        for (int i = 0; i < V; i++) {
            if (!vis[i] && edges[i] != -1) {
                int val = dfs(edges, i, count, vis, inRecursion);
                if (val > 1)
                    ans = Math.max(ans, val);
            }
        }
        return ans;
    }

    public int dfs(int[] edges, int u, int count[], boolean vis[], boolean inRecursion[]) {
        vis[u] = true;
        inRecursion[u] = true;
        int v = edges[u];
        int val = -1;

        if(v != -1) {
            if (vis[v] && inRecursion[v]) {
                inRecursion[u] = false;
                return count[u] - count[v] + 1;
            }
            else if (!vis[v]) {
                count[v] = count[u] + 1;
                val = dfs(edges, v, count, vis, inRecursion);
            }
        }
        inRecursion[u] = false;
        return val;
    }
}
class Solution {
    // Tarjan's Algorithm

    // tin -> The time at which the current node can be visited
    // min -> The lowest time at which the current node can be visited
    int timer = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean vis[] = new boolean[n];
        int min[] = new int[n];
        int tin[] = new int[n];

        List<Integer> adj[] = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < connections.size(); i++) {
            adj[connections.get(i).get(0)].add(connections.get(i).get(1));
            adj[connections.get(i).get(1)].add(connections.get(i).get(0));
        }

        dfs(0, -1, adj, ans, vis, min, tin);
        return ans;
    }
    public void dfs(int node, int parent, List<Integer> adj[], List<List<Integer>> ans, boolean vis[], int min[], int tin[]) {
        vis[node] = true;
        min[node] = tin[node] = timer;
        timer++;

        for(int v : adj[node]) {
            if(v == parent) continue;
            if(!vis[v]) {
                dfs(v, node, adj, ans, vis, min, tin);
                // If neighbour has a less min, then the current node will take that min
                min[node] = Math.min(min[node], min[v]);
                // If the current node has less min than this neighbour then it means that neighbour 
                // cannot be visited before the current node and cannot be visited if this edge does not 
                // exist, hence this edge is a bridge.
                if(min[v] > tin[node]) {
                    ans.add(Arrays.asList(node, v));
                }
            }
            else {
                min[node] = Math.min(min[node], tin[v]);
            }
        }
    }
}
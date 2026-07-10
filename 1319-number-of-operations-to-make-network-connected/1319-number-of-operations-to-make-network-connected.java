class Solution {
    public int makeConnected(int n, int[][] connections) {
        int edgesLen = connections.length;
        if(edgesLen < n - 1) return -1;
        int parent[] = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        int rank[] = new int[n];
        int components = n;

        for(int i = 0; i < edgesLen; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            int parent_u = find(u, parent);
            int parent_v = find(v, parent);

            if(parent_u != parent_v) {
                union(u, v, parent, rank);
                components -= 1;
            }
        }
        return components - 1;
    }
    public int find(int u, int parent[]) {
        if(parent[u] == u) return u;
        parent[u] = find(parent[u], parent);
        return parent[u];
    }
    public void union(int x, int y, int parent[], int rank[]) {
        int parent_x = find(x, parent);
        int parent_y = find(y, parent);

        if(parent_x == parent_y) return;
        if(rank[parent_x] > rank[parent_y]) {
            parent[parent_y] = parent_x;
        }
        else if(rank[parent_x] < rank[parent_y]) {
            parent[parent_x] = parent_y;
        }
        else {
            parent[parent_x] = parent_y;
            rank[parent_y]++;
        }
    }
}
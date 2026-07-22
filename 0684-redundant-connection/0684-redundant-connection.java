class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int parent[] = new int[n+1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        int rank[] = new int[n+1];
        for(int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            int parent_u = find(u, parent);
            int parent_v = find(v, parent);
            if(parent_u == parent_v) {
                return edges[i];
            }
            else {
                union(u, v, parent, rank);
            }
        }
        return new int[]{0, 0};
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
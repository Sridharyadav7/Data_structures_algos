class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int parent[] = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int rank[] = new int[n];
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            union(u, v, parent, rank);
        }
        if(find(source, parent) == find(destination, parent)) return true;
        return false;
    }
    public int find(int u, int parent[]) {
        if(u == parent[u]) return u;
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
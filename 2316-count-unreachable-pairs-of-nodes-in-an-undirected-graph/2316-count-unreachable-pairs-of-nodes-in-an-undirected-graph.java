class Solution {
    public long countPairs(int n, int[][] edges) {
        int parent[] = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int rank[] = new int[n];
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int parent_u = find(u, parent);
            int parent_v = find(v, parent);

            if(parent_u != parent_v) union(u, v, parent, rank);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int root = find(i, parent);
            map.put(root, map.getOrDefault(root, 0) + 1);
        }
        List<Integer> components = new ArrayList<>();
        for(int val : map.values()) {
            components.add(val);
        }
        long ans = 0;
        int rem = n;
        for(int size : components) {
            rem -= size;
            ans += (long) size * rem;
        }
        return ans;
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
            parent[parent_y] = parent_x;
            rank[parent_x]++;
        }
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int parent[] = new int[n];
        int rank[] = new int[n];

        for(int i = 0; i < n; i++) parent[i] = i;

        for(int i = 0; i < n - 1; i++) {
            int row = stones[i][0];
            int col = stones[i][1];

            for(int j = i + 1; j < n; j++) {
                if(stones[j][0] == row || stones[j][1] == col) {
                    union(i, j, parent, rank);
                }
            }
        }
        Set<Integer> groups = new HashSet<>();
        for(int i = 0; i < n; i++) {
            groups.add(find(i, parent));
        }
        
        return n - groups.size();
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
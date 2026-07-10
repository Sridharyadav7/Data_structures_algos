class Solution {
    public boolean equationsPossible(String[] equations) {
        int n = equations.length;
        int rank[] = new int[26];
        int parent[] = new int[26];
        for(int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for(int i = 0; i < n; i++) {
            String s = equations[i];
            if(s.substring(1,3).equals("==")) {
                union(s.charAt(0) - 'a', s.charAt(3) - 'a', parent, rank);
            }
        }
        for(int i = 0; i < n; i++) {
            String s = equations[i];
            if(s.substring(1,3).equals("!=")) {
                int parent1 = find(s.charAt(0) - 'a', parent);
                int parent2 = find(s.charAt(3) - 'a', parent);
                if(parent1 == parent2) return false;
            }
        }
        return true;
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
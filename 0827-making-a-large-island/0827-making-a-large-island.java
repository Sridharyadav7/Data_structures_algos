class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int zeroes = 0;
        int ones = 0;
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, -1, 0, 1}; 

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    zeroes++;
                }
                else ones++;
            }
        }

        if(zeroes == n * n) return 1;
        if(ones == n * n) return n * n;

        int parent[] = new int[n * n];
        int size[] = new int[n * n];
        for(int i = 0; i < n * n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                
                if(grid[i][j] ==1) {
                    int node = i * n + j;
                    for(int ind = 0; ind < 4; ind++) {
                        int nr = i + delRow[ind];
                        int nc = j + delCol[ind];

                        int neigh = nr * n + nc;
                        if(nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                            union(node, neigh, parent, size);
                        }
                    }
                }
            }
        }

        int maxSize = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    int currSize = 0;
                    for(int ind = 0; ind < 4; ind++) {
                        int nr = i + delRow[ind];
                        int nc = j + delCol[ind];

                        if(nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                            int neigh = nr * n + nc;
                            int parentOfIsland = find(neigh, parent);
                            if(!set.contains(parentOfIsland))  {
                                currSize += size[parentOfIsland];
                                set.add(parentOfIsland);
                            }
                        }
                    }
                    maxSize = Math.max(maxSize, currSize + 1);
                }
            }
        }
        return maxSize;
    }

    public int find(int u, int parent[]) {
        if(u == parent[u]) return u;
        parent[u] = find(parent[u], parent);
        return parent[u];
    }

    public void union(int x, int y, int parent[], int size[]) {
        int parent_x = find(x, parent);
        int parent_y = find(y, parent);

        if(parent_x == parent_y) return;
        if(size[parent_x] >= size[parent_y]) {
            parent[parent_y] = parent_x;
            size[parent_x] += size[parent_y];
        }
        else {
            parent[parent_x] = parent_y;
            size[parent_y] += size[parent_x];
        }
    }
}
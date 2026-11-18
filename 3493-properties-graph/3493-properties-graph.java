class Solution {
    public int numberOfComponents(int[][] properties, int k) {
        int n = properties.length;
        int m = properties[0].length;
        List<Integer> adj[] = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                int val = getDistinct(m, properties[i], properties[j]);

                if (val >= k) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }

        boolean vis[] = new boolean[n];
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                components++;
                dfs(adj, i, vis);
            }
        }

        return components;
    }
    public void dfs(List<Integer> adj[], int u, boolean vis[]) {
        vis[u] = true;

        for (int v: adj[u]) {
            if (!vis[v]) {
                dfs(adj, v, vis);
            }
        }
        return;
    }
    public int getDistinct(int n, int arr1[], int arr2[]) {
        Set<Integer> set = new HashSet<>();
        int cnt = 0;

        for (int num : arr1) {
            set.add(num);
        }

        for (int num : arr2) {
            if (set.remove(num)) {
                cnt++;
            }
        }
        return cnt;
    }
}
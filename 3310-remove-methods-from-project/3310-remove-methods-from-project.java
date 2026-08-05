class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer> adj[] = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < invocations.length; i++) {
            adj[invocations[i][0]].add(invocations[i][1]);
        }

        List<Integer> ans = new ArrayList<>();
        Set<Integer> bugs = new HashSet<>();
        Queue<Integer> que = new LinkedList<>();
        boolean vis[] = new boolean[n];

        que.add(k);
        vis[k] = true;

        while(!que.isEmpty()) {
            int u = que.poll();
            bugs.add(u);

            for(int v : adj[u]) {
                if(!vis[v]) {
                    vis[v] = true;
                    que.add(v);
                }
            }
        }

        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];
            if (!bugs.contains(u) && bugs.contains(v)) {
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }
        for (int i = 0; i < n; i++) {
            if (!bugs.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}
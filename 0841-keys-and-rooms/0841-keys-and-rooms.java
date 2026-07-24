class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int cnt = 0;
        int n = rooms.size();
        Queue<Integer> que = new LinkedList<>();
        boolean vis[] = new boolean[n];
        vis[0] = true;
        que.add(0);

        while(!que.isEmpty()) {
            int u = que.poll();
            cnt += 1;

            for(int v : rooms.get(u)) {
                if(!vis[v]) {
                    que.add(v);
                    vis[v] = true;
                }
            }
        }

        return cnt == n ? true : false;
    }
}
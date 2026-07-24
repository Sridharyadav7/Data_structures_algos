class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        int lastNode = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            int maxNode = Math.max(u, v);
            lastNode = Math.max(lastNode, maxNode);

            map.put(u, map.getOrDefault(u, 0) + 1);
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        for(int key : map.keySet()) {
            if(map.get(key) == lastNode - 1) return key;
        }
        return 0;
    }
}
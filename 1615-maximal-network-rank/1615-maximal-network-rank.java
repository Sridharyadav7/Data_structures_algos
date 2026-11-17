class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            adj.get(roads[i][0]).add(roads[i][1]);
            adj.get(roads[i][1]).add(roads[i][0]);
        }

        int maxRank = 0;
        
        for (int u = 0; u < n; u++) {
            for (int v = u + 1; v < n; v++) {
                int currRank = adj.get(u).size() + adj.get(v).size();

                if (adj.get(v).contains(u)) {
                    currRank -= 1;
                }

                maxRank = Math.max(maxRank, currRank);
            }
        }

        return maxRank;
    }
}
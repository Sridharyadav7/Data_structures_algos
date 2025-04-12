class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        Set<Integer> visited = new HashSet<>();
        for(int i=0;i<=isConnected.length;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[i].length;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i+1).add(j+1);
                    adj.get(j+1).add(i+1);
                }
            }
        }
        int cnt=0;
        for(int i=1;i<=isConnected.length;i++){
            if(!visited.contains(i)){
                cnt++;
                dfs(i,adj,visited);
            }
        }
        return cnt;
    }

    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, Set<Integer> visited){
        visited.add(node);
        for(Integer i: adj.get(node)){
            if(!visited.contains(i)){
                dfs(i,adj,visited);
            }
        }
    }
}

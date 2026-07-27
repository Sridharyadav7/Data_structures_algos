class Solution {
    public int findJudge(int n, int[][] trust) {
        int inDeg[] = new int[n+1];
        int outDeg[] = new int[n+1];

        for(int i = 0; i < trust.length; i++) {
            int u = trust[i][0];
            int v = trust[i][1];

            inDeg[v]++;
            outDeg[u]++;
        }

        for(int i = 1; i <= n; i++) {
            if(inDeg[i] == n - 1 && outDeg[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
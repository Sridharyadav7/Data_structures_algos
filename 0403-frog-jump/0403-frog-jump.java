class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        Map<Integer, Integer> map = new HashMap<>();
        if(stones[1] > 1) return false;

        Boolean[][] dp = new Boolean[n][n];
        for(int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }
        return recurse(n, stones, 0, 1, map, dp);
    }
    public boolean recurse(int n, int[] stones, int prevInd, int ind, Map<Integer, Integer> map, Boolean[][] dp) {
        if(ind >= n - 1) {
            return true;
        }
        if(dp[prevInd][ind] != null) {
            return dp[prevInd][ind];
        }
        boolean res = false;
        for(int i = -1; i < 2; i++) {
            int val = stones[ind] - stones[prevInd] + i;
            if(map.containsKey(stones[ind] + val) && map.get(stones[ind] + val) > ind) {
                res = res || recurse(n, stones, ind, map.get(stones[ind] + val), map, dp);
            }
        }
        return dp[prevInd][ind] = res;
    }
}
class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int components[] = new int[n];
        components[0] = 0;
        for(int i = 1; i < n; i++) {
            if(nums[i] - nums[i-1] <= maxDiff) {
                components[i] = components[i-1];
            }
            else components[i] = components[i-1] + 1;
        }
        boolean result[] = new boolean[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int source = queries[i][0];
            int dest = queries[i][1];
            if(components[source] == components[dest]) {
                result[i] = true;
            }
            else result[i] = false;
        }
        return result;
    }
}
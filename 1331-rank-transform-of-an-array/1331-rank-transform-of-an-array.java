class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        if(n == 1) return new int[]{1};
        if(n == 0) return new int[]{};
        int temp[] = arr.clone();
        Arrays.sort(temp);
        int ans[] = new int[n];
        int curr = temp[0];
        int rank = 1;
        int i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(curr, rank);
        while(i < n) {
            if(temp[i] != curr) {
                rank++;
                curr = temp[i];
                map.put(curr, rank);
            }
            i++;
        }
        for(i = 0; i < n; i++) {
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }
}
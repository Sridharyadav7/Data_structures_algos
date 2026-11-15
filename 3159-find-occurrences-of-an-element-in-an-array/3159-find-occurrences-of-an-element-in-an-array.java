class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int n = nums.length;
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] == x) {
                indices.add(i);
            }
        }

        int res[] = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            if (queries[i] > indices.size()) {
                res[i] = -1;
            }
            else {
                res[i] = indices.get(queries[i] - 1);
            }
        }

        return res;
    }
}
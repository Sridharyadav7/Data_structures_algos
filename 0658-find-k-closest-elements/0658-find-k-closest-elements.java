class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (que.size() < k) {
                que.add(arr[i]);
            }
            else {
                int prevDis = Math.abs(que.peek() - x);
                int currDis = Math.abs(arr[i] - x);

                if (currDis < prevDis) {
                    que.poll();
                    que.add(arr[i]);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!que.isEmpty()) {
            ans.add(que.poll());
        }

        return ans;
    }
}
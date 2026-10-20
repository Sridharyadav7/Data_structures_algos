class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        if (n == 1) {
            return 1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int s : stones) {
            pq.add(s);
        }

        while (pq.size() > 1) {
            int s1 = pq.poll();
            int s2 = pq.poll();

            if (s1 != s2) {
                pq.add(Math.abs(s1 - s2));
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}
class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<Pair> weights = new PriorityQueue<>((a, b) -> {
            if (a.weight == b.weight) {
                return Integer.compare(a.ind, b.ind);
            }
            return Integer.compare(a.weight, b.weight);
        });

        PriorityQueue<Pair> task = new PriorityQueue<Pair>((a, b) -> {
            if (a.completionTime == b.completionTime) {
                if (a.weight == b.weight) {
                    return a.ind - b.ind;
                }
                return a.weight - b.weight;
            }
            return a.completionTime - b.completionTime;
        });

        for (int i = 0; i < servers.length; i++) {
            weights.add(new Pair(servers[i], 0, i));
        }

        int currTime = 0;
        int res[] = new int[tasks.length];

        for (int i = 0; i < tasks.length; i++) {

            currTime = Math.max(currTime, i);

            while (!task.isEmpty() && task.peek().completionTime <= currTime) {
                weights.add(task.poll());
            }

            while (weights.isEmpty()) {
                currTime = task.peek().completionTime;

                while (!task.isEmpty() && task.peek().completionTime <= currTime) {
                    weights.add(task.poll());
                }
            }

            Pair curr = weights.poll();
            int newCompTime = currTime + tasks[i];
            res[i] = curr.ind;
            task.add(new Pair(curr.weight, newCompTime, curr.ind));
        }

        return res;
    }
}

class Pair {
    int weight;
    int completionTime;
    int ind;

    public Pair (int _weight, int _completionTime, int _ind) {
        this.weight = _weight;
        this.completionTime = _completionTime;
        this.ind = _ind;
    }
}
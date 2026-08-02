class Solution {
    public int largestComponentSize(int[] nums) {
        int n = nums.length;
        int parent[] = new int[n];
        int size[] = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        Map<Integer, Integer> factorMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            for (int factor = 2; factor * factor <= num; factor++) {
                if (num % factor == 0) {

                    // factor
                    if (factorMap.containsKey(factor)) {
                        union(i, factorMap.get(factor), parent, size);
                    } else {
                        factorMap.put(factor, i);
                    }

                    // Remove all occurrences of this factor
                    while (num % factor == 0) {
                        num /= factor;
                    }
                }
            }

            // Remaining prime factor (> sqrt(original number))
            if (num > 1) {
                if (factorMap.containsKey(num)) {
                    union(i, factorMap.get(num), parent, size);
                } else {
                    factorMap.put(num, i);
                }
            }
        }


        int maxSize = 0;
        for(int i = 0; i < n; i++) {
            maxSize = Math.max(maxSize, size[i]);
        }
        return maxSize;
    }

    public int find(int u, int parent[]) {
        if(u == parent[u]) return u;
        parent[u] = find(parent[u], parent);
        return parent[u];
    }

    public void union(int x, int y, int parent[], int size[]) {
        int parent_x = find(x, parent);
        int parent_y = find(y, parent);

        if(parent_x == parent_y) return;
        if(size[parent_x] > size[parent_y]) {
            parent[parent_y] = parent_x;
            size[parent_x] += size[parent_y];
        }
        else {
            parent[parent_x] = parent_y;
            size[parent_y] += size[parent_x];
        }
    }
}
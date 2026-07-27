class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        int parent[] = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int rank[] = new int[n];

        for(int i = 0; i < n - 1; i++) {
            Set<String> emails = new HashSet<>();
            for(int ind = 1; ind < accounts.get(i).size(); ind++) {
                emails.add(accounts.get(i).get(ind));
            }
            for(int j = i+1; j < n; j++) {
                for(String email : accounts.get(j)) {
                    if(emails.contains(email)) {
                        union(i, j, parent, rank);
                        break;
                    }
                }
            }
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int root = find(i, parent);
            if (map.get(root) == null) {
                map.put(root, new ArrayList<>());
            }
            map.get(root).add(i);
        }

        List<List<String>> ans = new ArrayList<>();
        for(int key : map.keySet()) {
            List<String> list = new ArrayList<>();
            list.add(accounts.get(map.get(key).get(0)).get(0));

            Set<String> emailSet = new HashSet<>();
            for (int i = 0; i < map.get(key).size(); i++) {
                List<String> account = accounts.get(map.get(key).get(i));
                for (int email = 1; email < account.size(); email++) {
                    emailSet.add(account.get(email));
                }
            }
            List<String> emails = new ArrayList<>(emailSet);
            Collections.sort(emails);
            list.addAll(emails);

            ans.add(list);
        } 
        return ans;
    }

    public int find(int u, int parent[]) {
        if(u == parent[u]) return u;
        parent[u] = find(parent[u], parent);
        return parent[u];
    } 

    public void union(int x, int y, int parent[], int rank[]) {
        int parent_x = find(x, parent);
        int parent_y = find(y, parent);

        if(parent_x == parent_y) return;
        if(rank[parent_x] > rank[parent_y]) {
            parent[parent_y] = parent_x;
        }
        else if(rank[parent_x] < rank[parent_y]) {
            parent[parent_x] = parent_y;
        }
        else {
            parent[parent_x] = parent_y;
            rank[parent_y]++;
        }
    }
}
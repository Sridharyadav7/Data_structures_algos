/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minimumOperations(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = que.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                level.add(node.val);

                if (node.left != null) {
                    que.add(node.left);
                }

                if (node.right != null) {
                    que.add(node.right);
                }
            }
            list.add(level);
        }

        int swaps = 0;

        for (int ind = 1; ind < list.size(); ind++) {
            List<Integer> currList = list.get(ind);
            int n = currList.size();
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                map.put(currList.get(i), i);
            }

            Collections.sort(currList);
            boolean vis[] = new boolean[n];

            for (int i = 0; i < n; i++) {
                if (vis[i] || i == map.get(currList.get(i))) {
                    continue;
                }

                int curr = i;
                int cycleLen = 0;

                while (!vis[curr]) {
                    vis[curr] = true;
                    curr = map.get(currList.get(curr));
                    cycleLen++;
                }

                swaps += cycleLen - 1;
            }
        }

        return swaps;
    }
}
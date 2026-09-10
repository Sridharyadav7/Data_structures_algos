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
    int cnt;
    public int averageOfSubtree(TreeNode root) {
        cnt = 0;
        check(root);
        return cnt;
    }
    public int[] check(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int leftSubtree[] = check(root.left);
        int rightSubtree[] = check(root.right);

        int nodes = leftSubtree[0] + rightSubtree[0] + 1;
        int sum = leftSubtree[1] + rightSubtree[1] + root.val;

        if (root.val == (int) (Math.floor(sum / nodes))) {
            cnt++;
        }
        return new int[]{nodes, sum};
    }
}
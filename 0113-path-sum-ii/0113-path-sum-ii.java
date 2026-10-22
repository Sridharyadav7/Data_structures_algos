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
    int target;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        solve(root, 0, list, ans);
        return ans;
    }
    public void solve(TreeNode root, int sum, List<Integer> list, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }

        int currSum = sum + root.val;
        list.add(root.val);

        if (root.left == null && root.right == null && currSum == target) {
            ans.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        
        solve(root.left, currSum, list, ans);
        solve(root.right, currSum, list, ans);
        list.remove(list.size() - 1);

        return;
    }
}
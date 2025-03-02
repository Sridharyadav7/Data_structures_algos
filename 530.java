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
    public int getMinimumDifference(TreeNode root) {
        int minDis[]=new int[1];
        TreeNode prev[]=new TreeNode[1];
        minDis[0]=Integer.MAX_VALUE;
        findMin(root,minDis,prev);
        return minDis[0];
    }
    public void findMin(TreeNode root, int[] minDis, TreeNode[] prev){
        if(root==null) return;
        findMin(root.left, minDis, prev);
        if(prev[0]!=null){
            minDis[0]=Math.min(minDis[0], Math.abs(root.val-prev[0].val));
        }
        prev[0]=root;
        findMin(root.right, minDis, prev);
    }
}
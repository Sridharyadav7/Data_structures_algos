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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        insert(root,val);
        return root;
    }
    public void insert(TreeNode root,int val){
        if(root.left==null && val<root.val){
            root.left=new TreeNode(val); return;
        }
        else if(root.right==null && val>root.val){
            root.right=new TreeNode(val); return;
        }
        else if(val<root.val){
            insert(root.left,val);
        }
        else insert(root.right,val);
    }
}
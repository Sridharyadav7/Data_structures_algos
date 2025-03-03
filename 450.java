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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;
        else if(key<root.val) root.left=deleteNode(root.left,key);
        else if(key>root.val) root.right=deleteNode(root.right,key);
        else {
            if(root.left!=null && root.right!=null){
                TreeNode temp=findMax(root.left);
                root.val=temp.val;
                root.left=deleteNode(root.left,root.val);
            }
            else{
                if(root.left==null && root.right==null) return null;
                else if(root.left==null) return root.right;
                else return root.left;
            }
        }
        return root;
    }
    public TreeNode findMax(TreeNode root){
        if(root==null) return root;
        if(root.right==null) return root;
        return findMax(root.right);
    }
}
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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root=new TreeNode(preorder[0]);
        for(int i=1;i<preorder.length;i++){
            TreeNode temp=createTree(root,preorder[i]);
        }
        return root;
    }
    public TreeNode createTree(TreeNode root, int val){
        if(root.left==null && val<root.val){
            root.left=new TreeNode(val); return root.left;
        }
        if(root.right==null && val>root.val){
            root.right=new TreeNode(val); return root.right;
        }
        if(val<root.val) return createTree(root.left,val);
        return createTree(root.right,val);
    }
}
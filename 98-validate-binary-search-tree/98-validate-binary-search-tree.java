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
    public boolean isValidBST(TreeNode root) {
        
        if(root == null || root.left == null && root.right == null) return true;
        
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isBST(TreeNode root, long min, long max){
        
        if(root == null) return true;
        
        if(root.val <= min) return false;
        
        if(root.val >= max) return false;
        
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }
}
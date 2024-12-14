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
    private int maxDepth = -1;
    private int leftbottomValue = 0;
    public int helper(TreeNode root, int level){
        if(root == null) return 0;

        if(level > maxDepth){
            maxDepth = level;
            leftbottomValue =  root.val;
        }
        helper(root.left , level + 1);
        helper(root.right , level + 1);
        return leftbottomValue;
        
    }
    public int findBottomLeftValue(TreeNode root) {

        return helper(root,0);

    }
}
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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0; // checking if the tree is null


        //calling recursion to find the maximum value using math.max of both subtree recursion 
        //also adding 1 for the root node
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

        
    }
}
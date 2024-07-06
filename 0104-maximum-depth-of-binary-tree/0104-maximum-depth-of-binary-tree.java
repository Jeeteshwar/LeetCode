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
        if(root == null){ // if the tree is empty
            return 0;
        }

        if(root.left == null && root.right == null){ //if both leftsub tree and right subtree is empty return only root node
            return 1;
        }

        if(root.left == null){ // if left tree if empty , return depth of right subtree
            return 1 + maxDepth(root.right);
        
        }
        if(root.right == null){  // if right tree if empty , return depth of left subtree
            return 1 + maxDepth(root.left);
        }

        //IF BOTH SUBTREES ARE PRESENT THEN FIND MIN DEPTH USING MATH.MIN AND RECURSION
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));

        
    }
}
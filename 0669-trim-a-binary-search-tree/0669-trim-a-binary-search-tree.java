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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // Base case: If the root is null, return null (end of branch)
        if (root == null) return null;

        // Recursively trim the left and right subtrees
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        // Check if the current node's value is outside the specified range
        if (root.val > high || root.val < low) {
            // If the current node's value is greater than high, discard this node
            // and all nodes in its right subtree, return the left subtree.
            if (root.left != null) return root.left;
            
            // If the current node's value is less than low, discard this node
            // and all nodes in its left subtree, return the right subtree.
            else return root.right;
        }

        // If the current node's value is within the range, return the node
        return root;
    }
}

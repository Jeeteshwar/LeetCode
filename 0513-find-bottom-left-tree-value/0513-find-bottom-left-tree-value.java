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
    private int bottomLeftValue = 0;

    public void helper(TreeNode root, int level) {
        if (root == null) return;

        // Update the bottom-left value if this is the deepest level encountered so far
        if (level > maxDepth) {
            maxDepth = level;
            bottomLeftValue = root.val;
        }

        // Traverse left subtree first
        helper(root.left, level + 1);
        // Traverse right subtree
        helper(root.right, level + 1);
    }

    public int findBottomLeftValue(TreeNode root) {
        helper(root, 0);
        return bottomLeftValue;
    }
}

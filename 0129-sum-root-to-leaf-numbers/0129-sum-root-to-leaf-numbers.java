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
    // Helper function that calculates the number represented by each root-to-leaf path
    public int help(TreeNode root, int num) {
        // Base case: if we reach a null node, return 0
        if(root == null)
            return 0;

        // Accumulate the current node’s value by shifting the number left by one decimal place
        num = num * 10 + root.val;

        // If it's a leaf node (no children), return the accumulated number for this path
        if(root.left == null && root.right == null)
            return num;

        // Recursively calculate the sum for left and right subtrees, accumulating the sum of all paths
        return help(root.left, num) + help(root.right, num);
    }

    // Main function to initialize the recursive process
    public int sumNumbers(TreeNode root) {
        // Start recursion with the initial number as 0
        return help(root, 0);
    }
}

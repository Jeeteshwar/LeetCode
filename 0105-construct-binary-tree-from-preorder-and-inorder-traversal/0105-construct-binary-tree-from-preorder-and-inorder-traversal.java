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

    // Helper method to construct the binary tree recursively
    public TreeNode helper(int[] preorder, int[] inorder, int start, int end, int[] idx) {
        // Base case: If start is greater than end, return null indicating an empty subtree
        if (start > end) {
            return null;
        }

        // The current root value is taken from the preorder traversal using idx[0]
        int rootval = preorder[idx[0]];
        int i = start;

        // Find the index of rootval in the inorder traversal to divide the tree into left and right subtrees
        for (; i <= end; i++) {
            if (inorder[i] == rootval) {
                break;
            }
        }

        // Move to the next element in the preorder array for the next recursive call
        idx[0]++;

        // Create a new TreeNode with the current root value
        TreeNode root = new TreeNode(rootval);

        // Recursively build the left subtree using elements left to the root in inorder traversal
        root.left = helper(preorder, inorder, start, i - 1, idx);

        // Recursively build the right subtree using elements right to the root in inorder traversal
        root.right = helper(preorder, inorder, i + 1, end, idx);

        // Return the constructed root of the current subtree
        return root;
    }

    // Main method to build the binary tree from preorder and inorder traversals
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        int[] idx = {0}; // Array to maintain the current index in preorder traversal
        return helper(preorder, inorder, 0, n - 1, idx); // Start building from the entire range of elements
    }
}

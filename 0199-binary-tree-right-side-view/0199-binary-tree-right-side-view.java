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
    // Helper method to perform preorder traversal and populate the result list
    void preorder(TreeNode root, List<Integer> result, int level) {
        // Base case: if the node is null, return
        if (root == null) return;

        // If the current level is equal to the size of the result list, 
        // it means we are visiting this level for the first time, so add the root node's value
        if (result.size() == level) {
            result.add(root.val);
        } else {
            // Otherwise, update the value at the current level with the node's value
            result.set(level, root.val);
        }
        
       

        // Recur for the left subtree to handle cases where right child is missing (first becuse when we do the rightsub the result overwrite the old left sub tree values)
        preorder(root.left, result, level + 1);

         // Recur for the right subtree
        preorder(root.right, result, level + 1);
    }
    
    // Method to return the right side view of the binary tree
    public List<Integer> rightSideView(TreeNode root) {
        // Initialize the result list
        List<Integer> result = new ArrayList<>();
        // Call the helper method to populate the result list
        preorder(root, result, 0);
        // Return the result list
        return result;
    }
}
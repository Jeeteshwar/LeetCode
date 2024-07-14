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
    public TreeNode reverseOddLevels(TreeNode root) {
        // Call the helper function to start the BFS traversal and reverse nodes at odd levels
        BFS(root.left,root.right,1);
        return root;
    }
     // Helper function for BFS traversal
    public void BFS(TreeNode root1 , TreeNode root2 , int level){
        if(root1 == null || root2 == null) return; // Base case: if either node is null, return

        if(level % 2 == 1){ // If the current level is odd, swap the values of the two nodes
            int temp = root1.val;
            root1.val = root2.val;
            root2.val = temp;
        }
         // Recursively call the BFS function for the left and right children
        BFS(root1.left , root2.right, level + 1);
        BFS(root1.right, root2.left , level + 1);

    }
}
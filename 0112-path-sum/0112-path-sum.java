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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false; // if the tree is empty return false

        targetSum -= root.val; // substracting the current node from the target sum

        if(targetSum == 0 && root.left == null && root.right == null) return true;
        // if sum is 0 and both subtrees are empty then pass the true as the tree has only one root node

        return  hasPathSum(root.left,targetSum) ||  hasPathSum(root.right,targetSum);
        // return either one of the subtree that has the required sum(boolean recursion)
    }
}
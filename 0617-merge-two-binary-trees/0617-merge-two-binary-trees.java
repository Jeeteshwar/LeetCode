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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null) return root2; // base case for root 1
        if(root2 == null) return root1; // base case for root 2

        root1.val += root2.val; // adding the each nodes value of root1 + root2 into root1;

        root1.left = mergeTrees(root1.left , root2.left); // rescursive call for left sub tree of both tree 
                                                         //[root1.left and root2.left] and sum of leftsub tree will be added into {Tree -> root1.left}
        root1.right = mergeTrees(root1.right, root2.right);
                                                        // rescursive call for right sub tree of both tree 
                                                         //[root1.right and root2.right] and sum of rightsub tree will be added into {Tree -> root1.right}
        
        return root1; // since it has sum of both trees
    }
}
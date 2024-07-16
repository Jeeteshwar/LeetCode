/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
          // Base case: if root is null, there is no ancestor.
        if(root == null) 
            return null;

        // If the root matches either p or q, then the root is the LCA.
        if(root == p  || root == q)
             return root;
        // Recursion for the left and right subtrees.
        TreeNode LeftN = lowestCommonAncestor(root.left, p , q);
        TreeNode RightN = lowestCommonAncestor(root.right, p , q);

        // If both left and right subtrees return non-null values, it means p and q
        // are found in different subtrees, hence the current root is the LCA.

        if(LeftN != null && RightN != null) 
            return root;

        // If one of the subtrees returns a non-null value, it means both p and q
        // are located in that subtree, so return that subtree's result.
        if(LeftN != null){
            return LeftN;
        }
        // If the left subtree is null, return the result from the right subtree.
        return RightN;

    }
}
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) // if both trees are null -> return true
            return true;
        
        if(p == null || q == null)  // if any one of the tree is null  -> return null
            return false;
        
        if(p.val == q.val) // Enter body of if block only if the root node of both trees are equal
            return isSameTree(p.left , q.left) && isSameTree(p.right , q.right); // recursive boolean call with the help of && 
                                                                                //(basically checks if both tree's subtree is equals 
                                                                                //if both true then true
                                                                                // if any false then both false
        return false;
    }
}
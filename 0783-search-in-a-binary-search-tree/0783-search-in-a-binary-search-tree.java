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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){ // if the root is null means no nodes in tree -> return null;
            return null;
        }
        if(root.val == val){ // if the root node is the target value that means we found the value and return it
            return root;
        }
        // recursive call and return !
        if(root.val > val){ // if the root value is greater than it means val is smaller that it so we will try to find it in the left sub tree
           return searchBST(root.left,val);
        }
        else{
           return searchBST(root.right,val); // if the root value is smaller than it means val is greater that it so we will try to find it in the right sub tree
        }
    }
}
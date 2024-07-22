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
    int sum = 0; // initialize the variable outside the methods to use in either global or local
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root); // calling the heloer function
        return sum; // return the sum of the even grandparent nodes
    }
    public void dfs(TreeNode root){
        if(root == null) return;

        if(root.val % 2 == 0){ // main even check of grandparent nodes
            if(root.left != null){ // checking if left sub tree is not null 

                if(root.left.left != null) sum += root.left.left.val; // recursively visiting and adding the even values (root.left.left)
                if(root.left.right != null) sum += root.left.right.val; // recursively visiting and adding the even values (root.left.right)
        }
        
        if(root.right != null){ // checking if right sub tree is not null 
            if(root.right.left != null) sum += root.right.left.val; // recursively visiting and adding the even values (root.right.left)
            if(root.right.right != null) sum += root.right.right.val; // recursively visiting and adding the even values (root.right.right)
        }
    }

        dfs(root.left); //recursively call the left sub tree
        dfs(root.right); //recursively call the right sub tree

    }
}
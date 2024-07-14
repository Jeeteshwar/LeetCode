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
    int ans = Integer.MAX_VALUE; // to keep the ans
    int count = 1; // initially at 1
    boolean found = false; // initially false

    public int kthSmallest(TreeNode root, int k) {
       if(root == null) return 0; //if tree is null

    
        // inorder traversal recursively

       kthSmallest(root.left,k); // left subtree traversal

       if(count == k ){ // if the current count matches the kth value
        ans = root.val; //assign the current node value into the ans variable
        found = true; //to flag that kth variable is found 
       }
       count++; // increment the count of count variable after each visit

        kthSmallest(root.right,k); // // right subtree traversal

        return ans;
    }
}
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
    private TreeNode Helper(int [] nums, int left,int right){ // Making a helper for recursion
        if (left > right) return null; // base case for recursion exit

        int mid = left + (right - left)/ 2; // finding the mid of the array

        TreeNode root = new TreeNode(nums[mid]); // making a new root node with the help of mid element

        root.left = Helper(nums,left, mid-1 );  // recursion function to build the left subtree

        root.right = Helper(nums , mid + 1 , right);    // recursion function to build the right subtree

        return root; //return the ROOTNODE

    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return Helper(nums,0,nums.length-1); // calling the Helper function to build the tree
    }
}
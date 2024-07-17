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
 *
 */
class Solution {
    // Helper method to construct the Maximum Binary Tree 
    public TreeNode Helper(int low , int high , int [] nums){
        // Base case: if low index is greater than high, return null (no tree to build)
        if(low > high) return null;

        // Initialize maxVal to the first element in the range
        // and max_index to the low index

        int maxVal = nums[low]; // index's value;
        int max_index  = low;  // index

       
        // Iterate over the range from low to high to find the maximum value and its index

        for(int i  = low ; i <= high ; i++){
            if(nums[i] > maxVal){
                maxVal = nums[i];
                max_index = i;
            }
        }
        // Create a new TreeNode with the maximum value found
        TreeNode root = new TreeNode(maxVal);

        // Recursively construct the left subtree with the elements to the left of the max value
        root.left = Helper(low , max_index - 1 , nums);

        // Recursively construct the right subtree with the elements to the right of the max value
        root.right = Helper(max_index + 1 , high , nums);

         // Return the root of the subtree
        return root;

    }
    // Main Method to build the actual tree
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // base case to check of the nums array is empty
        if(nums == null) return null;

        // Calling helper function from range of 0 to n - 1 , and passing the nums array as well
        return Helper(0,nums.length-1 , nums);
        
    }
}
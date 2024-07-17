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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
         // Convert the to_delete array into a set for efficient lookup
        Set<Integer> set = new HashSet<>();

        for(int i : to_delete){
            set.add(i);
        }
        // Initialize the answer list to store the resulting forest
        List<TreeNode> ans = new ArrayList <>();

        // If the root is not to be deleted, add it to the answer list
        if(!set.contains(root.val)) 
            ans.add(root);

        // Start the traversal from the root
        traverse(root,set,ans,null,false);
        return ans;
        
    }
    private void traverse(TreeNode root, Set<Integer> set,List<TreeNode> ans, TreeNode parent,boolean isLeft){
        if(root == null) return; // Base case: if the current node is null, return

        // If the current node's value is in the set of nodes to delete
        if(set.contains(root.val)){

            if(parent != null){  // If the current node has a parent, break the link to the parent
                
                if(isLeft){
                    parent.left = null;
                }
                else{
                    parent.right = null;
                }

            }
            // If the left child exists and is not in the set to delete, add it to the answer list
            if(root.left != null && !set.contains(root.left.val)){ 
                ans.add(root.left);
            }
            // If the right child exists and is not in the set to delete, add it to the answer list
            if(root.right != null && !set.contains(root.right.val)){
                ans.add(root.right);
            }
        }

        // Recursively traverse the left and right subtrees
        traverse(root.left,set,ans,root,true);
        traverse(root.right,set,ans,root,false);
    }
}
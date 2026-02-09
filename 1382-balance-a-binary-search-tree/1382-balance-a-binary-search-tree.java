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
    private List <TreeNode> sortedArr = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
         Inorder(root);
        return SortedArrayTOBST(0, sortedArr.size()-1 );
        
    }

    private void Inorder(TreeNode root){
        if(root == null) return;
        Inorder(root.left);
        sortedArr.add(root);
        Inorder(root.right);
    }
    private TreeNode SortedArrayTOBST(int low, int high){
        if(low > high) return null;
        int mid = low + (high - low) / 2;

        TreeNode root = sortedArr.get(mid);
        root.left = SortedArrayTOBST(low , mid-1);
        root.right = SortedArrayTOBST(mid + 1 , high);
        return root;
    }
}
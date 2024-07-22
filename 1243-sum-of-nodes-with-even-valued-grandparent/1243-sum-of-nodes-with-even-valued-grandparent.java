class Solution {
    int sum = 0; // Initialize sum to store the sum of values of nodes with even-valued grandparents
    
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root); // Start the depth-first search (DFS) from the root
        return sum; // Return the final sum
    }
    
    // Helper method to perform DFS on the tree
    public void dfs(TreeNode root){
        if(root == null) return; // Base case: if the current node is null, return
        
        // Check if the current node's value is even
        if(root.val % 2 == 0){ 
            // If the left child exists, check its children
            if(root.left != null){ 
                if(root.left.left != null) sum += root.left.left.val; // Add the left-left grandchild's value to sum if it exists
                if(root.left.right != null) sum += root.left.right.val; // Add the left-right grandchild's value to sum if it exists
            }
        
            // If the right child exists, check its children
            if(root.right != null){ 
                if(root.right.left != null) sum += root.right.left.val; // Add the right-left grandchild's value to sum if it exists
                if(root.right.right != null) sum += root.right.right.val; // Add the right-right grandchild's value to sum if it exists
            }
        }
        
        // Recursively call DFS on the left and right children
        dfs(root.left); 
        dfs(root.right);
    }
}

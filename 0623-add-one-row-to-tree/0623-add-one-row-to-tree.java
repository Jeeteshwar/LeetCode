class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // Base case: if the root is null, just return it (no tree to modify)
        if (root == null) return root;

        // If depth is 1, we need to add the new row at the top
        if (depth == 1) {
            // Create a new node with the given value
            TreeNode temp = new TreeNode(val);
            // The original root becomes the left child of the new node
            temp.left = root;
            // The new node becomes the new root
            root = temp;
        }

        // If depth is 2 , 3 , 4, 5 ..... n , we need to add the new row right below the current level

        if (depth - 1 == 1) { // Traverse down to one level above the desired depth

            // Create a new node with the given value
            TreeNode temp = new TreeNode(val);
            // The new node's left child becomes the original left child of the current root
            temp.left = root.left;
            // The new node becomes the left child of the current root -> (root node)
            root.left = temp; 

            // Create another new node with the given value
            TreeNode temp1 = new TreeNode(val);
            // The new node's right child becomes the original right child of the current root
            temp1.right = root.right;
            // The new node becomes the right child of the current root -> (root node)
            root.right = temp1;
        }

        // Recursively add a new row to the left subtree with depth decreased by 1
        addOneRow(root.left, val, depth - 1);
        // Recursively add a new row to the right subtree with depth decreased by 1
        addOneRow(root.right, val, depth - 1);

        // Return the modified root
        return root;
    }
}

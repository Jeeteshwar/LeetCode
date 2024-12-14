class Solution {
    // Variable to keep track of the total tilt of the tree
    private int totalTilt = 0;

    // Helper method to calculate the tilt of each node recursively
    public int helper(TreeNode root) {
        // Base case: If the node is null, the sum is 0
        if (root == null) return 0;

        // Recursively calculate the sum of values in the left subtree
        int leftSum = helper(root.left);

        // Recursively calculate the sum of values in the right subtree
        int rightSum = helper(root.right);

        // Calculate the tilt for the current node
        int tilt = Math.abs(leftSum - rightSum);

        // Add the current node's tilt to the total tilt
        totalTilt += tilt;

        // Return the total sum of values for the current subtree (node value + left subtree sum + right subtree sum)
        return root.val + leftSum + rightSum;
    }

    // Main method to calculate the total tilt of the tree
    public int findTilt(TreeNode root) {
        // Initialize the total tilt to 0
        totalTilt = 0;

        // Call the helper method to calculate tilt starting from the root
        helper(root);

        // Return the total tilt of the tree
        return totalTilt;
    }
}

class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        if (traversal == null || traversal.isEmpty()) {
            return null;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        int index = 0;
        
        while (index < traversal.length()) {
            // Calculate the depth of the current node
            int depth = 0;
            while (index < traversal.length() && traversal.charAt(index) == '-') {
                depth++;
                index++;
            }
            
            // Calculate the value of the current node
            int value = 0;
            while (index < traversal.length() && Character.isDigit(traversal.charAt(index))) {
                value = value * 10 + (traversal.charAt(index) - '0');
                index++;
            }
            
            // Create the current node
            TreeNode node = new TreeNode(value);
            
            // If the depth is 0, it's the root node
            if (depth == 0) {
                stack.push(node);
                continue;
            }
            
            // Pop nodes from the stack until we find the parent
            while (stack.size() > depth) {
                stack.pop();
            }
            
            // Attach the current node to the parent
            TreeNode parent = stack.peek();
            if (parent.left == null) {
                parent.left = node;
            } else {
                parent.right = node;
            }
            
            // Push the current node onto the stack
            stack.push(node);
        }
        
        // The root is the first node in the stack
        while (stack.size() > 1) {
            stack.pop();
        }
        
        return stack.pop();
    }
}
class FindElements {
    Set<Integer> elementsSet = new HashSet<>();

    private void populateTreeValues(TreeNode root, int initialValue) {
        Queue<TreeNode> queue = new LinkedList<>();
        root.val = initialValue;
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            elementsSet.add(currentNode.val);

            if (currentNode.left != null) {
                currentNode.left.val = 2 * currentNode.val + 1;
                queue.add(currentNode.left);
            }

            if (currentNode.right != null) {
                currentNode.right.val = 2 * currentNode.val + 2;
                queue.add(currentNode.right);
            }
        }
    }

    public FindElements(TreeNode root) {
        elementsSet.clear();
        populateTreeValues(root, 0);
    }

    public boolean find(int target) {
        return elementsSet.contains(target);
    }
}
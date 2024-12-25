class Solution {
    private List<Integer> res;
    
    private void helper(TreeNode root, int level) {
        if (root != null) {
            int val = root.val;
            if (res.size() == level) {
                res.add(val);
            } else {
                res.set(level, Math.max(res.get(level), val));
            }
            helper(root.left, level + 1);
            helper(root.right, level + 1);
        }
    }
    
    public List<Integer> largestValues(TreeNode root) {
        res = new ArrayList<>();
        helper(root, 0);
        return res;
    }
}

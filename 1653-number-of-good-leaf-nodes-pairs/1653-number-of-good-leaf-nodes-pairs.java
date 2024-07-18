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
    public int countPairs(TreeNode root, int distance) {
        int [] ans = new int[1];

        dfs(root,distance,ans);
        return ans[0];
    }
    private int [] dfs(TreeNode root , int distance , int[] ans){
        if(root == null) return new int[0];

        if(root.left == null && root.right == null) return new int[]{0};
    int[] leftDistances = dfs(root.left, distance, ans);
        int[] rightDistances = dfs(root.right, distance, ans);

        for (int l : leftDistances) {
            for (int r : rightDistances) {
                if (l + r + 2 <= distance) ans[0]++;
            }
        }

        int[] distances = new int[leftDistances.length + rightDistances.length];
        int index = 0;
        for (int l : leftDistances) distances[index++] = l + 1;
        for (int r : rightDistances) distances[index++] = r + 1;
        return distances;
    }
}
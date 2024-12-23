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
    public int countSwapsToSort(List<Integer> nums) {
        int swapCount = 0;
        List<Integer> sortedNums = new ArrayList<>(nums);
        Collections.sort(sortedNums);

        Map<Integer, Integer> indexMap = new HashMap<>(); // stores original indices
        for (int i = 0; i < nums.size(); i++) {
            indexMap.put(nums.get(i), i);
        }

        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i).equals(sortedNums.get(i))) {
                continue; // no need to swap
            }

            int originalIndex = indexMap.get(sortedNums.get(i));
            indexMap.put(nums.get(i), originalIndex);
            indexMap.put(nums.get(originalIndex), i);
            Collections.swap(nums, originalIndex, i);
            swapCount++;
        }

        return swapCount;
    }

    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int totalSwaps = 0;

        while (!nodeQueue.isEmpty()) {
            int levelSize = nodeQueue.size(); // number of nodes at the current level
            List<Integer> levelValues = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = nodeQueue.poll();
                levelValues.add(currentNode.val);

                if (currentNode.left != null) {
                    nodeQueue.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    nodeQueue.add(currentNode.right);
                }
            }

            totalSwaps += countSwapsToSort(levelValues);
        }

        return totalSwaps;
    }
}
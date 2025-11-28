import java.util.*;

class Solution {
    private Map<Integer, List<Integer>> adjacencyList;
    private int divisibleComponents;

    public int maxKDivisibleComponents(int nodes, int[][] edges, int[] nodeValues, int k) {
        adjacencyList = new HashMap<>();
        divisibleComponents = 0;

        for (int[] edge : edges) {
            adjacencyList.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adjacencyList.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }

        calculateSubtreeSum(0, -1, nodeValues, k);

        return divisibleComponents;
    }

    private int calculateSubtreeSum(int currentNode, int parent, int[] nodeValues, int k) {
        int subtreeSum = nodeValues[currentNode];

        for (int neighbor : adjacencyList.getOrDefault(currentNode, Collections.emptyList())) {
            if (neighbor != parent) {
                subtreeSum += calculateSubtreeSum(neighbor, currentNode, nodeValues, k);
            }
        }

        if (subtreeSum % k == 0) {
            divisibleComponents++;
            return 0;
        }

        return subtreeSum % k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int nodes = 5;
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {3, 4}};
        int[] nodeValues = {1, 2, 3, 4, 5};
        int k = 3;

        int result = solution.maxKDivisibleComponents(nodes, edges, nodeValues, k);
        System.out.println("Max K-Divisible Components: " + result);
    }
}

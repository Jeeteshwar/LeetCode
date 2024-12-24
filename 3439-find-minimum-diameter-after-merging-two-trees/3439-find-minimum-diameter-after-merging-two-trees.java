import java.util.*;

class Solution {
    private int[] performBFS(List<Integer>[] adjacencyList, int startNode, int totalNodes) {
        int[] distances = new int[totalNodes];
        Arrays.fill(distances, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        distances[startNode] = 0;
        int furthestNode = startNode;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int neighbor : adjacencyList[currentNode]) {
                if (distances[neighbor] == -1) {
                    distances[neighbor] = distances[currentNode] + 1;
                    queue.add(neighbor);
                    if (distances[neighbor] > distances[furthestNode]) {
                        furthestNode = neighbor;
                    }
                }
            }
        }
        return new int[]{furthestNode, distances[furthestNode]};
    }

    public int calculateDiameter(List<Integer>[] adjacencyList, int totalNodes) {
        int[] firstBFS = performBFS(adjacencyList, 0, totalNodes);
        int[] secondBFS = performBFS(adjacencyList, firstBFS[0], totalNodes);
        return secondBFS[1];
    }

    public int minimumDiameterAfterMerge(int[][] firstTree, int[][] secondTree) {
        int sizeTree1 = firstTree.length + 1;
        int sizeTree2 = secondTree.length + 1;
        List<Integer>[] adjacencyList1 = new ArrayList[sizeTree1];
        List<Integer>[] adjacencyList2 = new ArrayList[sizeTree2];

        for (int i = 0; i < sizeTree1; i++) {
            adjacencyList1[i] = new ArrayList<>();
        }
        for (int i = 0; i < sizeTree2; i++) {
            adjacencyList2[i] = new ArrayList<>();
        }

        for (int[] edge : firstTree) {
            adjacencyList1[edge[0]].add(edge[1]);
            adjacencyList1[edge[1]].add(edge[0]);
        }
        for (int[] edge : secondTree) {
            adjacencyList2[edge[0]].add(edge[1]);
            adjacencyList2[edge[1]].add(edge[0]);
        }

        int diameter1 = calculateDiameter(adjacencyList1, sizeTree1);
        int diameter2 = calculateDiameter(adjacencyList2, sizeTree2);
        int mergedDiameter = (diameter1 + 1) / 2 + (diameter2 + 1) / 2 + 1;

        return Math.max(Math.max(diameter1, diameter2), mergedDiameter);
    }
}

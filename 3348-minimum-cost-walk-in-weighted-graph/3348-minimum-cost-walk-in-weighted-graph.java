import java.util.Arrays;

class Solution {
    private int getRoot(int[] ancestor, int vertex) {
        if (ancestor[vertex] != vertex) {
            ancestor[vertex] = getRoot(ancestor, ancestor[vertex]);
        }
        return ancestor[vertex];
    }

    public int[] minimumCost(int totalNodes, int[][] connections, int[][] inquiries) {
        int[] ancestor = new int[totalNodes];
        int[] minEdgeCost = new int[totalNodes];
        Arrays.fill(minEdgeCost, -1);

        for (int i = 0; i < totalNodes; i++) {
            ancestor[i] = i;
        }

        for (int[] link : connections) {
            int pointA = link[0], pointB = link[1], cost = link[2];
            int rootA = getRoot(ancestor, pointA);
            int rootB = getRoot(ancestor, pointB);

            minEdgeCost[rootB] &= cost;

            if (rootA != rootB) {
                minEdgeCost[rootB] &= minEdgeCost[rootA];
                ancestor[rootA] = rootB;
            }
        }

        int[] response = new int[inquiries.length];
        for (int i = 0; i < inquiries.length; i++) {
            int startNode = inquiries[i][0], endNode = inquiries[i][1];
            if (startNode == endNode) {
                response[i] = 0;
            } else if (getRoot(ancestor, startNode) != getRoot(ancestor, endNode)) {
                response[i] = -1;
            } else {
                response[i] = minEdgeCost[getRoot(ancestor, startNode)];
            }
        }
        return response;
    }
}
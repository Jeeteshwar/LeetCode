class Solution {
    public int mostProfitablePath(int[][] edges, int bobNode, int[] amount) {
        ArrayList<Integer>[] adjacencyList = new ArrayList[amount.length];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adjacencyList[edge[0]].add(edge[1]);
            adjacencyList[edge[1]].add(edge[0]);
        }

        int[] bobPathTimestamps = new int[amount.length];
        Arrays.fill(bobPathTimestamps, -1);
        ArrayList<Integer> currentPath = new ArrayList<>();
        findBobPath(bobNode, -1, currentPath, adjacencyList);
        
        for (int i = 0; i < currentPath.size(); i++) {
            bobPathTimestamps[currentPath.get(i)] = i;
        }

        return calculateMaxAliceScore(0, -1, 0, bobPathTimestamps, adjacencyList, 0, amount);
    }

    private boolean findBobPath(int currentNode, int parentNode, ArrayList<Integer> currentPath, ArrayList<Integer>[] adjacencyList) {
        if (currentNode == 0) return true;
        for (int neighborNode : adjacencyList[currentNode]) {
            if (neighborNode != parentNode) {
                currentPath.add(currentNode);
                if (findBobPath(neighborNode, currentNode, currentPath, adjacencyList)) return true;
                currentPath.remove(currentPath.size() - 1);
            }
        }
        return false;
    }

    private int calculateMaxAliceScore(int currentNode, int parentNode, int currentScore, int[] bobPathTimestamps, ArrayList<Integer>[] adjacencyList, int timestamp, int[] amount) {
        if (bobPathTimestamps[currentNode] == -1 || bobPathTimestamps[currentNode] > timestamp) {
            currentScore += amount[currentNode];
        } else if (bobPathTimestamps[currentNode] == timestamp) {
            currentScore += amount[currentNode] / 2;
        }
        if (adjacencyList[currentNode].size() == 1 && currentNode != 0) return currentScore;
        int maxScore = Integer.MIN_VALUE;
        for (int neighborNode : adjacencyList[currentNode]) {
            if (neighborNode != parentNode) {
                maxScore = Math.max(maxScore, calculateMaxAliceScore(neighborNode, currentNode, currentScore, bobPathTimestamps, adjacencyList, timestamp + 1, amount));
            }
        }
        return maxScore;
    }
}
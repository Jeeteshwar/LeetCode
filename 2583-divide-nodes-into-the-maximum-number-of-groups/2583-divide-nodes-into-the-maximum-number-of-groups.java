class Solution {
    public int magnificentSets(int totalNodes, int[][] edges) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int node = 1; node <= totalNodes; node++) {
            adjacencyList.put(node, new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int nodeA = edge[0];
            int nodeB = edge[1];
            adjacencyList.get(nodeA).add(nodeB);
            adjacencyList.get(nodeB).add(nodeA);
        }
        
        Map<Integer, List<Integer>> connectedComponents = new HashMap<>();
        Set<Integer> visitedNodes = new HashSet<>();
        int componentId = 1;
        
        for (int node = 1; node <= totalNodes; node++) {
            if (visitedNodes.contains(node)) continue;
            visitedNodes.add(node);
            connectedComponents.put(componentId, new ArrayList<>());
            dfsFindComponents(componentId++, node, adjacencyList, connectedComponents, visitedNodes);
        }
        
        int[] maxComponentDepth = new int[componentId];
        int totalResult = 0;
        
        for (int comp = 1; comp < componentId; comp++) {
            for (int componentNode : connectedComponents.get(comp)) {
                int bfsResult = bfsMaxDepth(componentNode, adjacencyList);
                if (bfsResult == -1) return -1;
                maxComponentDepth[comp] = Math.max(maxComponentDepth[comp], bfsResult);
            }
            totalResult += maxComponentDepth[comp];
        }
        
        return totalResult;
    }

    private void dfsFindComponents(int componentId, int node, Map<Integer, List<Integer>> adjacencyList, Map<Integer, List<Integer>> connectedComponents, Set<Integer> visitedNodes) {
        connectedComponents.get(componentId).add(node);
        for (int neighbor : adjacencyList.get(node)) {
            if (visitedNodes.contains(neighbor)) continue;
            visitedNodes.add(neighbor);
            dfsFindComponents(componentId, neighbor, adjacencyList, connectedComponents, visitedNodes);
        }
    }

    private int bfsMaxDepth(int startNode, Map<Integer, List<Integer>> adjacencyList) {
        int depth = 0;
        Set<Integer> visitedNodes = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> currentLevel = new HashSet<>();
        
        queue.offer(startNode);
        visitedNodes.add(startNode);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Set<Integer> nextLevel = new HashSet<>();
            
            for (int i = 0; i < levelSize; i++) {
                int currentNode = queue.poll();
                
                for (int neighbor : adjacencyList.get(currentNode)) {
                    if (currentLevel.contains(neighbor)) return -1; // Odd cycle detected, not bipartite
                    if (visitedNodes.contains(neighbor)) continue;
                    nextLevel.add(neighbor);
                    visitedNodes.add(neighbor);
                    queue.offer(neighbor);
                }
            }
            
            currentLevel = nextLevel;
            depth++;
        }
        
        return depth;
    }
}

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int numNodes = graph.length;
        int[] incomingEdges = new int[numNodes];
        List<Integer>[] reversedGraph = new List[numNodes];
        Arrays.setAll(reversedGraph, node -> new ArrayList<>());
        Deque<Integer> queue = new ArrayDeque<>();
        
        for (int node = 0; node < numNodes; ++node) {
            for (int neighbor : graph[node]) {
                reversedGraph[neighbor].add(node);
            }
            incomingEdges[node] = graph[node].length;
            if (incomingEdges[node] == 0) {
                queue.offer(node);
            }
        }
        
        while (!queue.isEmpty()) {
            int currentNode = queue.pollFirst();
            for (int parent : reversedGraph[currentNode]) {
                if (--incomingEdges[parent] == 0) {
                    queue.offer(parent);
                }
            }
        }
        
        List<Integer> safeNodes = new ArrayList<>();
        for (int node = 0; node < numNodes; ++node) {
            if (incomingEdges[node] == 0) {
                safeNodes.add(node);
            }
        }
        return safeNodes;
    }
}

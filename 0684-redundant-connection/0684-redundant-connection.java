import java.util.*;

class Solution {
    public boolean depthFirstSearch(Map<Integer, List<Integer>> graph, int current, int target, boolean[] visited) {
        visited[current] = true;
        if (current == target) {
            return true;
        }
        for (int neighbor : graph.get(current)) {
            if (visited[neighbor]) continue;
            if (depthFirstSearch(graph, neighbor, target, visited)) {
                return true;
            }
        }
        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int numNodes = edges.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1];
            
            if (graph.containsKey(node1) && graph.containsKey(node2)) {
                boolean[] visited = new boolean[numNodes + 1];
                if (depthFirstSearch(graph, node1, node2, visited)) {
                    return edge;
                }
            }
            
            graph.putIfAbsent(node1, new ArrayList<>());
            graph.putIfAbsent(node2, new ArrayList<>());
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        return new int[0];
    }
}

import java.util.*;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        // Graph to store dependencies
        Map<String, List<String>> graph = new HashMap<>();
        // In-degree count for each recipe
        Map<String, Integer> inDegree = new HashMap<>();
        // Set to store available supplies
        Set<String> availableSupplies = new HashSet<>(Arrays.asList(supplies));
        // Queue for BFS
        Queue<String> queue = new LinkedList<>();
        // Result list
        List<String> result = new ArrayList<>();

        // Initialize the graph and in-degree count
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            List<String> ingredientList = ingredients.get(i);
            inDegree.put(recipe, ingredientList.size()); // Set in-degree to the number of ingredients
            for (String ingredient : ingredientList) {
                graph.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipe);
            }
        }

        // Add all available supplies to the queue
        queue.addAll(availableSupplies);

        // Perform BFS
        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (graph.containsKey(current)) {
                for (String neighbor : graph.get(current)) {
                    inDegree.put(neighbor, inDegree.get(neighbor) - 1); // Reduce in-degree
                    if (inDegree.get(neighbor) == 0) {
                        queue.add(neighbor); // Add to queue if in-degree is 0
                        result.add(neighbor); // Add to result
                    }
                }
            }
        }

        return result;
    }
}
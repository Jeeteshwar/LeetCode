class Solution {
    public int maximumInvitations(int[] favorites) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < favorites.length; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        int totalInvitations = 0;

        List<List<Integer>> mutualPairs = new ArrayList<>();
        for (int i = 0; i < favorites.length; i++) {
            if (i == favorites[favorites[i]]) {
                if (i < favorites[i]) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(favorites[i]);
                    mutualPairs.add(pair);
                }
            } else {
                adjacencyList.get(favorites[i]).add(i);
            }
        }

        boolean[] isVisited = new boolean[favorites.length];
        for (List<Integer> pair : mutualPairs) {
            totalInvitations += calculateDepth(adjacencyList, pair.get(0), isVisited) 
                                + calculateDepth(adjacencyList, pair.get(1), isVisited);
        }

        int[] visitDepth = new int[favorites.length];
        int[] visitCycle = new int[favorites.length];

        int cycleId = 1;

        int maxCircleSize = 0;

        for (int i = 0; i < favorites.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            if (visitCycle[i] != 0) {
                continue;
            }

            int depth = 1;
            int current = i;
            while (visitDepth[current] == 0) {
                visitDepth[current] = depth;
                visitCycle[current] = cycleId;
                current = favorites[current];
                depth++;
            }
            if (visitCycle[current] == cycleId) {
                maxCircleSize = Math.max(maxCircleSize, depth - visitDepth[current]);
            }
            cycleId++;
        }
        return Math.max(maxCircleSize, totalInvitations);
    }

    private int calculateDepth(List<List<Integer>> adjacencyList, int node, boolean[] isVisited) {
        isVisited[node] = true;
        int maxDepth = 0;
        for (int neighbor : adjacencyList.get(node)) {
            maxDepth = Math.max(maxDepth, calculateDepth(adjacencyList, neighbor, isVisited));
        }
        return maxDepth + 1;
    }
}

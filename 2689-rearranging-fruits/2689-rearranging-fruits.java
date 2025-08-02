class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer, Integer> fruitCountMap = new HashMap<>();
        int minFruitCost = Integer.MAX_VALUE;

        // Count fruits in basket1 and find the minimum cost fruit
        for (int fruitCost : basket1) {
            fruitCountMap.put(fruitCost, fruitCountMap.getOrDefault(fruitCost, 0) + 1);
            minFruitCost = Math.min(minFruitCost, fruitCost);
        }

        // Adjust counts with fruits from basket2
        for (int fruitCost : basket2) {
            fruitCountMap.put(fruitCost, fruitCountMap.getOrDefault(fruitCost, 0) - 1);
            minFruitCost = Math.min(minFruitCost, fruitCost);
        }

        ArrayList<Integer> fruitsToSwap = new ArrayList<>();

        // Prepare list of fruits that need to be swapped
        for (Map.Entry<Integer, Integer> entry : fruitCountMap.entrySet()) {
            int currentFruitCost = entry.getKey();
            int countDifference = entry.getValue();

            if (countDifference == 0) {
                continue;
            }

            if (countDifference % 2 != 0) {
                return -1;  // Can't balance if counts are odd
            }

            // Add half the absolute difference to swap list
            for (int i = 0; i < Math.abs(countDifference) / 2; i++) {
                fruitsToSwap.add(currentFruitCost);
            }
        }

        Collections.sort(fruitsToSwap);
        long totalMinCost = 0;

        // Calculate minimum cost by either swapping directly or via the cheapest fruit
        for (int i = 0; i < fruitsToSwap.size() / 2; i++) {
            totalMinCost += Math.min(fruitsToSwap.get(i), minFruitCost * 2);
        }

        return totalMinCost;
    }
}
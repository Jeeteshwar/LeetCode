class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));

        // Step 2: Sort queries with their original indices
        int[][] queriesWithIndex = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            queriesWithIndex[i][0] = queries[i];
            queriesWithIndex[i][1] = i;
        }
        Arrays.sort(queriesWithIndex, Comparator.comparingInt(a -> a[0]));

        int[] res = new int[queries.length];
        int maxBea = 0;
        int i = 0;

        for (int[] queryWithIndex : queriesWithIndex) {
            int query = queryWithIndex[0];
            int index = queryWithIndex[1];

            // Move through items that are within the current query's price range
            while (i < items.length && items[i][0] <= query) {
                maxBea = Math.max(maxBea, items[i][1]);
                i++;
            }

            // Store the max beauty for this query
            res[index] = maxBea;
        }
        return res;
    }
}
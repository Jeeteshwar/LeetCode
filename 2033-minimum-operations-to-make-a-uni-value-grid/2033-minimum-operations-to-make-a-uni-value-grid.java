class Solution {
    public int minOperations(int[][] grid, int x) {
     List<Integer> values = new ArrayList<>();
        for (int[] row : grid) {
            for (int val : row) {
                values.add(val);
            }
        }

        // Step 2: Sort the list to facilitate median calculation
        Collections.sort(values);

        // Step 3: Check if it's possible to make all values equal
        // The difference between any value and the first value must be divisible by x
        for (int val : values) {
            if (Math.abs(val - values.get(0)) % x != 0) {
                // If not, return -1 indicating it's impossible
                return -1;
            }
        }

        // Step 4: Find the median value to minimize counts
        // The median is the middle value in the sorted list
        int median = values.get(values.size() / 2);

        // Step 5: Calculate the total number of counts needed
        int counts = 0;
        for (int val : values) {
            // For each value, the number of counts is the absolute difference
            // between the value and the median, divided by x
            counts += Math.abs(val - median) / x;
        }

        // Step 6: Return the total number of counts
        return counts;
    }
}
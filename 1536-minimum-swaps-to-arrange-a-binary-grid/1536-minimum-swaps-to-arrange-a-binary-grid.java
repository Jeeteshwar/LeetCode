class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        List<Integer> arr = new ArrayList<>();

        // count trailing zeros
        for (int i = 0; i < n; i++) {
            int streak = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) streak++;
                else break;
            }
            arr.add(streak);
        }

        int steps = 0;

        for (int i = 0; i < n; i++) {
            // For row i to be valid, it must have at least (n - i - 1) zeros at the end
            // Example: first row needs n-1 zeros, second row needs n-2 zeros, etc.
            int need = n - i - 1;

            // Start checking from the current row
            int j = i;

            // Move downward to find a row that has enough trailing zeros
            // Keep going until we either find a valid row or reach the end
            while (j < n && arr.get(j) < need) j++;

            // If we reached the end and still didn't find a valid row,
            // it means no row below can satisfy this requirement
            // So making the grid valid is impossible
            if (j == n) return -1;

            // Option 1: Simulation
            // If we found a valid row at position j,
            // move it up to position i using adjacent swaps
            // (because the problem only allows swapping neighboring rows)
            while (j > i) {
                int temp = arr.get(j);
                arr.set(j, arr.get(j - 1));
                arr.set(j - 1, temp);
                steps++;   // count this swap
                j--;       // continue moving the row upward
            }

//----------------------------------------

            // Option 2: Instead of performing swaps,
            // count how many positions the row must move upward.
            // Remove the element at index j and insert it at index i.
            steps += j - i;
            int val = arr.remove(j);
            arr.add(i, val);

//--- note: comment out one of the two options ---

        }

        return steps;
    }
}
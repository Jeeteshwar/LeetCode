import java.util.Arrays;

class Solution {
    private int[] result;
    private boolean[] used;

    public int[] constructDistancedSequence(int n) {
        // The length of the sequence is 2n - 1
        result = new int[2 * n - 1];
        used = new boolean[n + 1]; // Track used numbers (1 to n)
        Arrays.fill(result, -1); // Initialize the result array with -1

        // Start backtracking from index 0
        backtrack(0, n);
        return result;
    }

    private boolean backtrack(int index, int n) {
        // If we've filled the entire sequence, return true
        if (index == result.length) {
            return true;
        }

        // If the current position is already filled, move to the next index
        if (result[index] != -1) {
            return backtrack(index + 1, n);
        }

        // Try placing the largest possible number first (for lexicographical order)
        for (int i = n; i >= 1; i--) {
            if (i == 1) {
                // Number 1 only appears once
                if (!used[i]) {
                    result[index] = i;
                    used[i] = true;
                    if (backtrack(index + 1, n)) {
                        return true;
                    }
                    // Backtrack
                    used[i] = false;
                    result[index] = -1;
                }
            } else {
                // For numbers greater than 1, they must appear twice with distance i
                if (!used[i] && index + i < result.length && result[index + i] == -1) {
                    result[index] = i;
                    result[index + i] = i;
                    used[i] = true;
                    if (backtrack(index + 1, n)) {
                        return true;
                    }
                    // Backtrack
                    used[i] = false;
                    result[index] = -1;
                    result[index + i] = -1;
                }
            }
        }

        // If no valid number can be placed, return false
        return false;
    }
}
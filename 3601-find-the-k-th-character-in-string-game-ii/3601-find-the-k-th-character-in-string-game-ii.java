class Solution {
    public char kthCharacter(long k, int[] operations) {
        int n = operations.length;
        long[] sizes = new long[n + 1];
        sizes[0] = 1;

        // Calculate size after each operation
        for (int i = 0; i < n; i++) {
            if (operations[i] == 0) {
                sizes[i + 1] = sizes[i] * 2;
            } else {
                sizes[i + 1] = sizes[i] * 2;
            }
            if (sizes[i + 1] >= k) {
                // No need to go beyond this point
                n = i + 1;
                break;
            }
        }

        int shift = 0; // total number of character shifts ('a' → 'b' etc.)

        // Traverse operations backwards
        for (int i = n - 1; i >= 0; i--) {
            long half = sizes[i];
            if (k > half) {
                k -= half;
                if (operations[i] == 1) {
                    shift++;
                }
            }
            // If in the first half, do nothing (k stays as is)
        }

        // Now we're in the base string, which is just "a"
        // Apply all the character shifts to 'a'
        char res = (char) ('a' + (shift % 26));
        return res;
    }
}

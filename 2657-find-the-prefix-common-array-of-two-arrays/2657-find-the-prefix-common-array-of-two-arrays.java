class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length; // Length of the input arrays
        int[] res = new int[n]; // Result array to store the prefix common count

        // Iterate over each index i in the arrays
        for (int i = 0; i < n; i++) {
            int count = 0; // Counter to count common elements in the prefix
            // Nested loop to compare elements in the prefix of A and B
            for (int j = 0; j <= i; j++) {
                for (int k = 0; k <= i; k++) {
                    // If elements in A and B at indices j and k are equal, increment the count
                    if (A[j] == B[k]) {
                        count++;
                    }
                }
            }
            // Store the count of common elements for the current prefix in the result array
            res[i] = count;
        }

        return res; // Return the result array
    }
}

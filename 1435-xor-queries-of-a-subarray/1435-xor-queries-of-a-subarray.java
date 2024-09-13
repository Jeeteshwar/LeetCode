class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;

        // Array to store the cumulative XOR results
        int[] cumXOR = new int[n];
        cumXOR[0] = arr[0];  // Initialize the first element of cumXOR with the first element of arr

        // Compute cumulative XOR for the array
        // cumXOR[i] will hold XOR of all elements from arr[0] to arr[i]
        for (int i = 1; i < n; i++) {  // Start from index 1 to avoid accessing cumXOR[-1]
            cumXOR[i] = cumXOR[i - 1] ^ arr[i];
        }

        // Array to store the results of each query
        int[] result = new int[queries.length];

        // Process each query
        for (int i = 0; i < queries.length; i++) {
            int L = queries[i][0];  // Left index of the query
            int R = queries[i][1];  // Right index of the query

            // If the left index is 0, the result is simply cumXOR[R]
            // Otherwise, we get the XOR from L to R by XORing cumXOR[R] and cumXOR[L - 1]
            if (L == 0) 
                result[i] = cumXOR[R];  // If L is 0, cumulative XOR from 0 to R gives the result
            else 
                result[i] = cumXOR[R] ^ cumXOR[L - 1];  // XOR from L to R can be derived using cumXOR[L-1] and cumXOR[R]
        }

        return result;  // Return the result array
    }
}

class Solution {
    public int[] decimalRepresentation(int n) {

        // This list will store each base-10 component (like 500, 30, 7)
        ArrayList<Integer> res = new ArrayList<>();

        // 'place' represents the current power of 10
        // Starts from 1 (10^0 → ones place)
        int place = 1;

        // Process the number until all digits are handled
        while (n > 0) {

            // Extract the last digit of the number
            int digit = n % 10;

            // If digit is not zero, it contributes to the number
            if (digit != 0) {

                // Multiply digit with its place value
                // Example: digit = 3, place = 10 → 3 * 10 = 30
                res.add(digit * place);
            }

            // Remove the last digit from n
            n /= 10;

            // Move to the next higher power of 10
            // 1 → 10 → 100 → 1000 ...
            place *= 10;
        }

        // Digits were processed from right to left,
        // so reverse to get descending order
        Collections.reverse(res);

        // Convert ArrayList to array as required by return type
        int m = res.size();
        int[] arr = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = res.get(i);
        }

        return arr;
    }
}

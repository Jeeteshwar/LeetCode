class Solution {
    public int generateKey(int n1, int n2, int n3) {
        String ans = "";

        // Continue until all digits are processed
        while (n1 > 0 || n2 > 0 || n3 > 0) {
            int d1 = n1 % 10;
            int d2 = n2 % 10;
            int d3 = n3 % 10;

            int min = Math.min(d1, Math.min(d2, d3));

            // Append the smallest digit to the left of the result
            ans = min + ans;

            // Reduce the original numbers (not the digits)
            n1 /= 10;
            n2 /= 10;
            n3 /= 10;
        }

        return Integer.parseInt(ans); // remove leading zeros automatically
    }
}

class Solution {
    public String fractionAddition(String expr) {
        int nume = 0;  // Initialize the numerator of the result
        int deno = 1;  // Initialize the denominator of the result to 1

        int i = 0;
        int n = expr.length();

        while (i < n) {
            int currNume = 0;  // Current numerator in the expression
            int currDeno = 0;  // Current denominator in the expression

            boolean isNeg = false;  // Flag to check if the fraction is negative

            // Check if the current fraction is negative
            if (expr.charAt(i) == '-' || expr.charAt(i) == '+') {
                isNeg = expr.charAt(i) == '-';
                i++;
            }

            // Parse the numerator
            while (i < n && Character.isDigit(expr.charAt(i))) {
                currNume = (currNume * 10) + (expr.charAt(i) - '0');
                i++;
            }

            // Skip the '/'
            i++;

            // Parse the denominator
            while (i < n && Character.isDigit(expr.charAt(i))) {
                currDeno = (currDeno * 10) + (expr.charAt(i) - '0');
                i++;
            }

            // Adjust for negative fractions
            if (isNeg) {
                currNume = -currNume;
            }

            // Calculate the new numerator and denominator of the result fraction
            nume = nume * currDeno + currNume * deno;
            deno = deno * currDeno;
        }

        // Simplify the fraction using the greatest common divisor (GCD)
        int gcd = gcd(Math.abs(nume), deno);
        nume /= gcd;
        deno /= gcd;

        // Return the result in the form "numerator/denominator"
        return nume + "/" + deno;
    }

    // Helper method to calculate the greatest common divisor (GCD) using the Euclidean algorithm
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}

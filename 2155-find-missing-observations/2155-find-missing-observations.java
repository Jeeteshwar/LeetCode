class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        // Calculate the length of the given rolls array
        int l = rolls.length;

        // Calculate the total sum required from all the dice rolls (given + missing)
        // Total numbers = (n + l) where 'n' is the number of missing rolls and 'l' is the given rolls length
        // The sum of all numbers would be (mean * (n + l))
        int sumOfTotalNumbers = mean * (n + l);

        // Initialize the sum of given rolls to 0
        int sumOfGivenRolls = 0;

        // Calculate the sum of all the given rolls
        for (int roll : rolls) {
            sumOfGivenRolls += roll;
        }

        // Calculate the remaining sum we need from the missing rolls
        int remainingSum = sumOfTotalNumbers - sumOfGivenRolls;

        // If the remaining sum is too high (greater than 6*n) or too low (less than n),
        // it's impossible to generate a valid result, so we return an empty array
        if (remainingSum > 6 * n || remainingSum < n) {
            return new int[0];
        }

        // Create an array to store the result (the missing rolls)
        int res[] = new int[n];

        // Calculate the average value for the missing rolls
        int q = remainingSum / n;  // Quotient: the base number each roll should have
        int r = remainingSum % n;  // Remainder: extra amount to distribute evenly

        // Fill the result array with the base [eq : 2 , 2 , 2 , 2 ,2 ] value (q) for each missing roll
        for (int i = 0; i < n; i++) {
            res[i] = q;
        }

        // Distribute the remainder (r) by adding 1 to the first 'r' elements
        //[eq : 3 , 3 , 3 , 2 , 2 ]
        for (int i = 0; i < r; i++) {
            res[i]++;
        }

        // Return the result array, which now contains the missing dice rolls
        return res;
    }
}

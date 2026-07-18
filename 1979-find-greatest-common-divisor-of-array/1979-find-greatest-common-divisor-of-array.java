class Solution {

    // Method to calculate GCD of two numbers
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Method to find GCD of the entire array
    public int findGCD(int[] nums) {
        // Initialize min and max with the first element of the array
        int smallest = nums[0];
        int largest = nums[0];

        // Loop through the array to find smallest and largest elements
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < smallest) {
                smallest = nums[i];
            }
            if (nums[i] > largest) {
                largest = nums[i];
            }
        }

        // Calculate the GCD of smallest and largest numbers
        return gcd(smallest, largest);
    }
}
class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0; // Initialize sum to accumulate the total of encrypted numbers
        
        // Process each number in the input array
        for(int num : nums){
            int cnt = 0; // Count of digits in the current number
            int max = 0; // Will store the maximum digit found in the number

            // Extract each digit of the number to find count and maximum digit
            while(num > 0){
                int d = num % 10; // Get the last digit
                max = Math.max(d, max); // Update max if current digit is larger
                num /= 10; // Remove the last digit
                cnt++; // Increment digit count
            }
            
            int x = 0; // Will store the encrypted number
            
            // Construct the encrypted number:
            // - Has same number of digits as original (cnt)
            // - All digits equal to max digit from original
            for(int j = 0 ; j < cnt ; j++){
                // Each iteration:
                // 1. Shifts existing digits left (multiply by 10)
                // 2. Appends max digit at the end
                x = x * 10 + max;
            }
            
            sum += x; // Add the encrypted number to the running total
        }
        
        return sum; // Return the final sum of all encrypted numbers
    }
}
class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n = arr.length;  // Get the length of the input array 'arr'
        
        // Initialize an array 'freq' to store the frequencies of remainders when elements are divided by 'k'
        int[] freq = new int[k];

        // Iterate over each element in the array 'arr'
        for (int num : arr) {
            int rem = num % k;  // Calculate the remainder when 'num' is divided by 'k'

            // If remainder is negative, adjust it by adding 'k' (ensures remainder is positive)
            if (rem < 0)
                rem += k;

            // Increment the count of this remainder in the 'freq' array
            freq[rem]++;
        }

        // Check if the number of elements divisible by 'k' (remainder 0) is even
        // If not, it's impossible to pair them off, so return false
        if (freq[0] % 2 != 0)
            return false;

        // For each remainder from 1 to k/2, check if the frequency of remainder 'i' 
        // matches with the frequency of remainder 'k - i'
        for (int i = 1; i <= k / 2; i++) {
            // If the frequencies don't match, return false (no valid pairing possible)
            if (freq[i] != freq[k - i]) {
                return false;
            }
        }

        // If all checks pass, return true (valid pairs can be formed)
        return true;
    }
}
